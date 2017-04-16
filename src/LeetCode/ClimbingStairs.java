package LeetCode;

public class ClimbingStairs {

    public int climbStairs(int n) {
        int n1 = 0, n2=0;
        int n0 = n;
        for(int i = 1; i <=n; i++){
            if(i <= 3){
                n1 = i;
                n2 = i - 1; 
            }else{
                n0 = n1 + n2;
                n2 = n1;
                n1 = n0;
            }
        }
        
        return n0;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
