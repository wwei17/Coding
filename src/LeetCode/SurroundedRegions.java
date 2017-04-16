package LeetCode;

import java.util.Stack;

public class SurroundedRegions {

    int h;
    int w;
    
    public void solve(char[][] board) {
        Stack<Integer> stack = new Stack<Integer>();
        h = board.length;
        if(h == 0) return;
        w = board[0].length;
        
        for(int i = 0 ; i < h; i++){
            if(board[i][0] == 'O'){
                stack.push(getIndex(i,0));
                board[i][0] = 'o';
            }
            if(board[i][w-1] == 'O'){
                stack.push(getIndex(i,w-1));
                board[i][w-1] = 'o';
            }
        }
        for(int i = 0 ; i < w; i++){
            if(board[0][i] == 'O'){
                stack.push(getIndex(0,i));
                board[0][i] = 'o';
            }
            if(board[h-1][i] == 'O'){
                stack.push(getIndex(h-1,i));
                board[h-1][i] = 'o';
            }
        }
        
        while(!stack.empty()){
            int k = stack.pop();
            int j = k%w;
            int i = k/w;
            
            if(i+1 < h && board[i+1][j] == 'O'){ 
                stack.push(getIndex(i+1, j));
                board[i+1][j] = 'o';
            }
            if(i-1 > 0 && board[i-1][j] == 'O'){ 
                stack.push(getIndex(i-1, j));
                board[i-1][j] = 'o';
            }
            if(j+1 < w && board[i][j+1] == 'O'){ 
                stack.push(getIndex(i, j+1));
                board[i][j+1] = 'o';
            }
            if(j-1 > 0 && board[i][j-1] == 'O'){ 
                stack.push(getIndex(i, j-1));
                board[i][j-1] = 'o';
            }
        }
        
        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if(board[i][j] == 'o'){
                    board[i][j] = 'O';
                }
            }
        }
     
        
    }
    
    int getIndex(int i, int j){
        return i*w+j;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
