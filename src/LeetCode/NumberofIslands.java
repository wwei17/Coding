package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class NumberofIslands {
	
    public int numIslands(char[][] grid) {
        int count = 0;
        int n = grid.length;
        if(n == 0){
            return 0;
        }
        int m = grid[0].length;
        CCC[][] ccc = new CCC[n][m];
        for(int i = 0 ; i < n; i++){
            for(int j = 0 ; j < m; j++){
                ccc[i][j] = null;
                if(grid[i][j] == '1'){
                    if(i > 0 && grid[i-1][j] == '1'){
                        ccc[i][j] = ccc[i-1][j];
                    }
                    if(j > 0 && grid[i][j-1]=='1'){
                    	ccc[i][j] = new CCC(ccc[i][j-1].value);
                    }
                    if(ccc[i][j] == null){
                        ccc[i][j] = new CCC(count++);
                    }
                    
                }
            }
        }
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0 ; i < n; i++){
            for(int j = 0 ; j < m; j++){
                if(ccc[i][j] != null) set.add(ccc[i][j].value);
            }
        }
        return set.size();
    }
    
    class CCC{
        int value;
        CCC(int _v){
            value = _v;
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberofIslands sln = new NumberofIslands();
		char [][] a = new char[][]{{'1','1'}};
		System.out.println(sln.numIslands(a));
	}

}
