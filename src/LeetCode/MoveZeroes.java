package LeetCode;

public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int j = 1; int temp = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==0){
                for(j = i>j? i+1:j; j < nums.length; j++){
                    if(nums[j]!=0){
                        nums[i] = nums[j];
                        nums[j] = 0;
                        break;
                    }
                }
            }
            if(j == nums.length){
                break;
            }
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
