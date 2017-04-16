package LeetCode;

public class BattleshipsinaBoard {

    public int countBattleships(char[][] board) {
        boolean[][] visited = new boolean[board.length][];
        for(int i = 0 ; i < board.length; i++){
            visited[i] = new boolean[board[i].length];
        }
        int count = 0;
        for(int i = 0 ; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(visited[i][j]){
                    continue;
                }else{
                    if(board[i][j] == 'X'){
                        int next_i = i;
                        int next_j = j;
                        boolean has_next = true;
                        while(has_next){
                            has_next = false;
                            visited[next_i][next_j] = true;
                            if(next_i < board.length-1){
                                visited[next_i+1][next_j] = true;
                                if(board[next_i+1][next_j] == 'X'){
                                    has_next = true;
                                    next_i = next_i+1;
                                }
                            }
                            if(next_j < board[next_i].length-1){
                                visited[next_i][next_j+1] = true;
                                if(board[next_i][next_j+1] == 'X'){
                                    has_next = true;
                                    next_j = next_j+1;
                                }
                            }
                        }
                        count ++;
                    }
                    visited[i][j] = true;
                }
            }
        }
        return count;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
