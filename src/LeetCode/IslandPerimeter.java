package LeetCode;

public class IslandPerimeter {

    public int islandPerimeter(int[][] grid) {
        int res = 0;
        for(int i = 0 ; i < grid.length; i++){
            for(int j = 0 ; j < grid[i].length; j++){
                if(grid[i][j]>0){
                    if(i > 0 && grid[i-1][j] > 0){
                        res-=2;
                    }
                    if(j > 0 && grid[i][j-1] > 0){
                        res-=2;
                    }
                    res+=4;
                }
            }
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
