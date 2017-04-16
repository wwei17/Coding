package LeetCode;

public class IncreasingTripletSubsequence {

    public boolean increasingTriplet(int[] nums) {
        int c1 = Integer.MAX_VALUE; int c2 = Integer.MAX_VALUE;
        for(int i = 0 ; i < nums.length; i++){
            if(nums[i] <= c1){
                c1 = nums[i];
            }else if(nums[i] <= c2){
                c2 = nums[i];
            }else{
                return true;
            }
        }
        return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
