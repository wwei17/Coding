package LeetCode;

public class ReverseInteger {
    public int reverse(int x) {
        int sign = x > 0? 1:-1;
        int r_x = 0;
        
        x = x>0? x: -1*x;
        
        while(x > 0){
            r_x *= 10;
            r_x += x%10;
            x = x/10;
        }
        return sign*r_x;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
