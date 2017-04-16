package LeetCode;

public class SingleNumber {

    public int singleNumber(int[] A) {
        int a = A[0];
        
        for(int i = 1; i< A.length; i++){
            a ^= A[i];
        }
        
        return a;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
