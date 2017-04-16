package LeetCode;

import java.util.Stack;


public class FriendCircles {

    public int findCircleNum(int[][] M) {
    	int count = 0;
    	Stack<Integer> ist = new Stack<Integer>(); 
    	Stack<Integer> jst = new Stack<Integer>(); 
    	for(int i = 0 ; i < M.length; i++){
    		if(M[i][i] == 1){
    			count++;
    			ist.push(i);jst.push(i);
    			while(ist.size()>0){
    				int ii = ist.pop();
    				int jj = jst.pop();
    		    	if(M[ii][jj] == 1){
    		    		M[ii][jj] = 2;
    		    		ist.push((ii+1)%M.length);jst.push(jj);
    		    		ist.push(ii);jst.push((jj+1)%M.length);
    		    		ist.push((ii-1+M.length)%M.length);jst.push(jj);
    		    		ist.push(ii);jst.push((jj-1+M.length)%M.length);
    		    	}
    			}

    		}
    		
    	}
    	
        return count;
    }
    
    public void dfs(int[][] M, int i , int j){
    	if(M[i][j] == 1){
    		M[i][j] = 2;
    		if(i + 1 < M.length && M[i+1][j] == 1) dfs(M, i+1, j);
    		if(j + 1 < M.length && M[i][j+1] == 1) dfs(M, i, j+1);
    		if(i - 1 >= 0 && M[i-1][j] == 1) dfs(M, i-1, j);
    		if(j - 1 >= 0 && M[i][j-1] == 1) dfs(M, i, j-1);
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FriendCircles sln = new FriendCircles();
		int [][]  a = {
				{1,0,0,1},
				{0,1,1,0},
				{0,1,1,1},
				{1,0,1,1}
				};
		//int [][] a = new int[100][100];
//		for(int j = 0 ; j< a.length ;j++){
//			for(int k = 0 ; k < a.length; k++){
//				a[j][k]=1;
//			}
//		}
		System.out.println(sln.findCircleNum(a));
	}

}
