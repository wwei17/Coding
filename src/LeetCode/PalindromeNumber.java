package LeetCode;

public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        int low = 0;
        int high = 0;
        
        double power = 0.1;
        
        int copy=x;
        while(copy != 0){
            copy = copy/10;
            power *= 10;
        }
        
        copy = x;
        while(copy != 0){
            low = copy % 10;
            high = (int) (copy / power);
            if(low != Math.abs(high)){
                return false;
            }
            copy -= high*power;
            copy = copy/10;
            power = power / 100;
        }
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
