package LeetCode;

public class ThirdMaximumNumber {

    public int thirdMax(int[] nums) {
        long max = Long.MIN_VALUE; long second =Long.MIN_VALUE; long third = Long.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > max){
                third = second;
                second = max;
                max = nums[i];
            }else if(nums[i] > second && nums[i] < max){
                third = second;
                second = nums[i];
            }else if(nums[i] > third && nums[i] < second){
                third = nums[i];
            }
        }
        if(third == Long.MIN_VALUE){
            return (int)max;
        }else{
            return (int)third;
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
