package LeetCode;

public class RotateFunction {

    public int maxRotateFunction(int[] A) {
        if(A == null || A.length == 0) return 0;
        int max = 0; int sum= 0; int sum1 = 0;
        for(int i = 0 ; i < A.length; i++){
            sum += A[i];
            max += A[i]*i;
        }
        sum1 = max;
        for(int i = 1 ; i <A.length; i++){
            sum1 += sum-A.length*A[A.length-i];
            max = sum1 > max? sum1: max;
        }
        return max;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
