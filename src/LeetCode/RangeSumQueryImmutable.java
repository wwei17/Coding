package LeetCode;

public class RangeSumQueryImmutable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	class NumArray {
	    private int [] sums;

	    public NumArray(int[] nums) {
	        sums = new int[nums.length+1];
	        sums[0]= 0;
	        for(int i = 0 ; i < nums.length; i++){
	            sums[i+1] = nums[i]+ sums[i];
	        }
	    }

	    public int sumRange(int i, int j) {
	        return sums[j+1]-sums[i];
	    }
	}

}


