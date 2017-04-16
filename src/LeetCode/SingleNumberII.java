package LeetCode;

public class SingleNumberII {

    public int singleNumber(int[] A){
        int t1 = 0;
        int t2 = 0;
        int x = 0;
        for(int i = 0; i < A.length; i++){
            x = (t2 & A[i]);
            t2 = t2 & ~x;
            x = A[i] & ~x;
            t2 |= t1 & x;
            t1 ^= x;
            x= ~(t2 & t1);
            t2 &= x;
            t1 &= x;
        }
        return t2 | t1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
