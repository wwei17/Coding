package LeetCode;

public class SumofTwoIntegers {

    public int getSum(int a, int b) {
        int b1 = 0, b2 = 0, c = 0;
        int res = 0;
        for(int i = 0; i <32; i++){
            b1 = (a >>> i) & 1;
            b2 = (b >>> i) & 1;
            res |= (b1^b2^c) << i;
            c = (b1&b2) | (b1&c) | (b2&c);
        }
        return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
