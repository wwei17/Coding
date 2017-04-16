package LeetCode;

import java.util.HashSet;

public class Minesweeper {

    public char[][] updateBoard(char[][] board, int[] click) {
        if(board[click[0]][click[1]] == 'M'){
            board[click[0]][click[1]] = 'X';
        }else{
            HashSet<Integer> set1 = new HashSet<Integer>();
            HashSet<Integer> set2 = new HashSet<Integer>();
            int key = (click[0]<<10)|click[1];
            set1.add(key);
            int [][] index = {{-1,-1},{-1,0}, {-1, 1}, {0,-1}, {0, 1}, {1,-1},{1,0}, {1, 1}};
            while(set1.size() > 0){
                HashSet<Integer> set3 = new HashSet<Integer>();
                for(Integer k : set1){
                    int x = k >> 10;
                    int y = k & 255;
                    int x1 = 0, y1 = 0, k1 = 0, count = 0;
                    set2.add(k);
                    HashSet<Integer> set4 = new HashSet<Integer>();
                    for(int i = 0 ;i < index.length; i++){
                        x1 = x+index[i][0];
                        y1 = y+index[i][1];
                        k1 = (x1<<10)|y1;
                        if( x1 >=0 && x1 < board.length && 
                            y1 >=0 && y1 < board[x1].length){
                            if(board[x1][y1] == 'M') count++;
                            if(!set2.contains(k1))set4.add(k1);
                        }
                    }
                    if(count == 0){
                        set3.addAll(set4);
                        board[x][y] = 'B';
                    }else board[x][y] = (char)('0'+count);
                }
                set1 = set3;
            }
        }
        return board;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
