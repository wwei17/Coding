package LeetCode;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int count = (nums.length+1)*nums.length/2;
        for(int i = 0 ; i < nums.length; i++){
            count = count - nums[i];
        }
        return count;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
