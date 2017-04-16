package LeetCode;

public class MaximumSubarray {

    public int maxSubArray(int[] A) {
        int max =Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < A.length; i++){
            sum+=A[i];
            max = sum>max? sum:max;
            if(sum < 0){
                sum = 0;
            }
        }
        return max;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
