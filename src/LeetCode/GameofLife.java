package LeetCode;

public class GameofLife {

    
    //00 -> previous dead, next dead
    //01 -> previous live, next dead
    //10 -> previous dead, next live
    //11 -> previous live, next live
    public void gameOfLife(int[][] board) {
        int countL = 0; 
        for(int i = 0 ; i < board.length; i++){
            for(int j = 0 ; j < board[i].length; j++){
                countL = 0; 
                if(i > 0){
                    if(board[i-1][j] %2 == 1){
                        countL++;
                    }
                }
                if(j > 0){
                    if(board[i][j-1] %2 == 1){
                        countL++;
                    }
                }
                if(i < board.length-1){
                    if(board[i+1][j] %2 == 1){
                        countL++;
                    }
                }
                if(j < board[i].length-1){
                    if(board[i][j+1]%2 == 1){
                        countL++;
                    }
                }
                if(i > 0 && j > 0){
                    if(board[i-1][j-1]%2 == 1){
                        countL++;
                    }
                }
                if(i > 0 && j < board[i].length-1){
                    if(board[i-1][j+1]%2 == 1){
                        countL++;
                    }
                }
                if(i < board.length-1 && j > 0){
                    if(board[i+1][j-1]%2 == 1){
                        countL++;
                    }
                }
                if(i < board.length-1 && j < board[i].length-1){
                    if(board[i+1][j+1]%2 == 1){
                        countL++;
                    }
                }
                
                if(board[i][j] == 1){
                    if(countL == 2 || countL == 3){
                        board[i][j] = 3;    //live
                    }else{
                        board[i][j] = 1;    //die
                    }
                }else{
                    if(countL == 3){
                        board[i][j] = 2;    //live
                    }
                }
            }
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0 ; j<board[i].length; j++){
                board[i][j] = board[i][j] >> 1;
            }
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] a = new int[][]{{1,1},{1,0}};
		GameofLife sln = new GameofLife();
		sln.gameOfLife(a);
		for(int i = 0 ; i <a.length; i++){
			for(int j = 0 ; j < a[i].length; j++){
				System.out.print(a[i][j]+ " ");
			}
			System.out.println();
		}

	}

}
