package LeetCode;

public class ArithmeticSlices {

    public int numberOfArithmeticSlices(int[] A) {
        if(A == null || A.length < 3) return 0;
        int count = 0; int gap = 0; int pre_gap = A[1] - A[0];
        int len = 2;
        for(int i = 2 ; i < A.length; i++){
            gap = A[i] - A[i-1];
            if(gap != pre_gap){
                if(len >= 3){
                    count += (len*len-3*len)/2+1;
                }
                pre_gap = gap;
                len = 2;
            }else{
                len++;
            }
        }
        if(len >= 3){
            count +=(len*len-3*len)/2+1;
        }
        return count;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
