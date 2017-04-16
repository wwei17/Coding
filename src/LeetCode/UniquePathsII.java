package LeetCode;

public class UniquePathsII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] count = new int[m][n];
        
        if(obstacleGrid[0][0] == 0){
            count[0][0] = 1;
            for(int i = 0; i < m; i++){
                for(int j = 0; j<n; j++){
                    if(obstacleGrid[i][j] == 0){
                        if(i == 0){
                            if(j == 0){
                                
                            }else{
                                count[i][j] = count[i][j-1];
                            }
                        }else{
                            if(j == 0){
                                count[i][j] = count[i-1][j];
                            }else{
                                count[i][j] = count[i-1][j]+count[i][j-1];
                            }
                        }
                    }else{
                        count[i][j] = 0;
                    }
                }
            }
            
        }else{
            return 0;
        }
        return count[m-1][n-1];
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
