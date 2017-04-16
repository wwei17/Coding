package LeetCode;

public class EliminationGame {

    public int lastRemaining(int n) {
        int res = 1; int lev = 0;
        while(n > 1){
            if(lev%2 == 1 && n%2 == 0){
                
            }else{
                res += 1 << lev;
            }
            n /=2;
            lev++;
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
