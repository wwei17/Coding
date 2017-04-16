package LeetCode;

public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        int N = grid.length;
        if(N == 0) return 0;
        int M = grid[0].length;
        for(int i = 0 ; i < N; i++){
            for(int j = 0 ; j < M; j++){
                if(i == 0){
                    if(j == 0){
                        
                    }else{
                        grid[i][j] = grid[i][j-1] + grid[i][j]; 
                    }
                }else{
                    if(j == 0){
                        grid[i][j] = grid[i-1][j] + grid[i][j]; 
                    }else{
                        grid[i][j] = Math.min(grid[i-1][j], grid[i][j-1]) + grid[i][j];
                    }
                }
            }
        }
        return grid[N-1][M-1];
        
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
