package LeetCode;

public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        if( n == 0) return 0;
        int m = matrix[0].length;
        int[][] counter = new int[n][m];
        
        
        for(int i = 0 ; i < n; i++){
            if(matrix[i][0] == '1'){
                counter[i][0] = 1;   
            }else{
                counter[i][0] = 0;  
            }
        }
        
        for(int j = 0 ; j < m; j++){
            if(matrix[0][j] == '1'){
                counter[0][j] = 1;   
            }else{
                counter[0][j] = 0;  
            }
        }
        
        for(int i = 1 ; i < n; i++){
            for(int j = 1 ; j < m ; j++){
                if(matrix[i][j] == '1'){
                    counter[i][j] =  Math.min(counter[i-1][j], Math.min(counter[i][j-1], counter[i-1][j-1]))+1;
                }else{
                    counter[i][j] = 0;
                }
            }
            
        }
        int max = counter[0][0];
        for(int i = 0 ; i < n; i++){
            for(int j = 0 ; j < m ; j++){
                if(counter[i][j] > max){
                    max = counter[i][j];
                }
            }
            
        }
        return max*max;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximalSquare s = new MaximalSquare();
		char[][] matrix = new char[1][2];
		matrix[0][0] = '0';
		matrix[0][1] = '1';
		System.out.println(s.maximalSquare(matrix));

	}

}
