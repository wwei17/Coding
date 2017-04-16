package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        List<Map<Character, Integer>> H = new ArrayList<Map<Character, Integer>>();
        List<Map<Character, Integer>> V = new ArrayList<Map<Character, Integer>>();
        List<Map<Character, Integer>> B = new ArrayList<Map<Character, Integer>>();
        HashMap<Character, Integer> temp = null;
        for(int i = 0; i < 9; i ++){
            H.add(new HashMap<Character, Integer>());
            V.add(new HashMap<Character, Integer>());
            B.add(new HashMap<Character, Integer>());
        }
        for(int i = 0; i < 9; i++){
            for(int j =0; j< 9; j++){
                if(board[i][j] != '.'){
                    temp = (HashMap<Character, Integer>)H.get(i);
                    if(temp.containsKey(board[i][j])){
                        return false;
                    }else{
                        temp.put(board[i][j],1);
                    }
                    temp = (HashMap<Character, Integer>)V.get(j);
                    if(temp.containsKey(board[i][j])){
                        return false;
                    }else{
                        temp.put(board[i][j],1);
                    }
                    temp = (HashMap<Character, Integer>)B.get((i/3)*3+(j/3));
                    if(temp.containsKey(board[i][j])){
                        return false;
                    }else{
                        temp.put(board[i][j],1);
                    }
                }
            }
        }
        
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
