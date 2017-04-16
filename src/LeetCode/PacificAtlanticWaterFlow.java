package LeetCode;

import java.util.*;

public class PacificAtlanticWaterFlow {

	public List<int[]> pacificAtlantic(int[][] matrix) {
	    List<int[]> list= new ArrayList<int[]>();
	    if(matrix == null || matrix.length == 0) return list;
        boolean[][] fromP = new boolean[matrix.length][]; 
        boolean[][] fromA = new boolean[matrix.length][]; 
        for(int i = 0; i  <matrix.length; i++){
            fromP[i] = new boolean[matrix[i].length];
            fromA[i] = new boolean[matrix[i].length];
        }
        Stack<Integer> st = new Stack<Integer>();
        for(int i = 0; i  <matrix.length; i++){
        	st.push(i << 8 | 0);
        	fromP[i][0] = true;
        }
        for(int j = 0 ; j < matrix[0].length; j++){
        	st.push(0 << 8 | j);
        	fromP[0][j] = true;
    	}
        flow(matrix, fromP, st);
        
        st.clear();
        for(int i = matrix.length-1; i >=0; i--){
        	st.push(i << 8 | matrix[i].length-1);
        	fromA[i][matrix[i].length-1] = true;
        }
        for(int j = 0 ; j < matrix[matrix.length-1].length; j++){
        	st.push((matrix.length-1) << 8 | j);
        	fromA[matrix.length-1][j] = true;
    	}
        flow(matrix, fromA, st);

        for(int i = 0; i<matrix.length ; i++){
            for(int j = 0; j<matrix[i].length ; j++){
                if(fromA[i][j] && fromP[i][j]){
                    list.add(new int[]{i, j});
                }
            }
        }
        return list;    
    }
	
	public void flow(int[][] matrix, boolean[][] from, Stack<Integer> st){
        while(st.size() > 0){
        	int k = st.pop();
        	int i = k >> 8;
        	int j = k & 255;
        	int key = (i-1) << 8 | j;
        	if(i > 0 && matrix[i][j] <= matrix[i-1][j] && !from[i-1][j]) {
        		st.push(key);
        		from[i-1][j] =true;
        	}
        	key = i << 8 | (j-1);
        	if(j > 0 && matrix[i][j] <= matrix[i][j-1] && !from[i][j-1]) {
        		st.push(key);
        		from[i][j-1] =true;
        	}
        	key = (i+1) << 8 | j;
        	if(i < matrix.length-1 && matrix[i][j] <= matrix[i+1][j] && !from[i+1][j]) {
        		st.push(key);
        		from[i+1][j] =true;
        	}
        	key = i << 8 | (j+1);
        	if(j < matrix[i].length-1 && matrix[i][j] <= matrix[i][j+1] && !from[i][j+1]) {
        		st.push(key);
        		from[i][j+1] =true;
        	}
        }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PacificAtlanticWaterFlow sln = new PacificAtlanticWaterFlow();
		int[][] matrix = {{1,2,3,4},{12,13,14,5},{11,16,15,6},{10,9,8,7}};
		for(int i = 0 ;i  < matrix.length; i ++){
			for(int j = 0 ;j  < matrix[i].length; j++){
				System.out.print(matrix[i][j]+" ");
			}
			System.out.print("\n");
		}
		List<int[]> res = sln.pacificAtlantic(matrix);
		for(int i = 0 ;i  < res.size(); i ++){
			System.out.print("{"+res.get(i)[0]+","+res.get(i)[1]+"}, ");
		}
	}

}
