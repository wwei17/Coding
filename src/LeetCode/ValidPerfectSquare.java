package LeetCode;

public class ValidPerfectSquare {

    public boolean isPerfectSquare(int num) {
        if(num == 0 || num == 1 || num == 4){
            return true;
        }else{
            long a = 2; long b = a*a;
            while(b*b < num){
                a = b;
                b = b*b;
            }
            while (a < b){
                long mid = (a+b)/2;
                long s = mid*mid;
                if(s < num){
                    a = mid+1;
                }else if(s > num){
                    b = mid;
                }else{
                    return true;
                }
            }
            return a*a == num;
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
