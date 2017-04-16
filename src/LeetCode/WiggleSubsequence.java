package LeetCode;

public class WiggleSubsequence {

    public int wiggleMaxLength(int[] nums) {
        int peak = 0; int bottom = 0;
        int len = 1; int next_peak = 0;
        if(nums.length < 2){
            return nums.length;
        }else{
            int pre = nums[0];
            for(int i = 1; i < nums.length; i++){
                if(nums[i] == nums[i-1]){ 
                    continue;
                }else if(next_peak > 0){
                    if(nums[i] > bottom){
                        len++;
                        peak = nums[i];
                        next_peak = -next_peak;
                    }
                    if(nums[i] < bottom){
                        bottom = nums[i];
                    }
                }else if(next_peak < 0){
                    if(nums[i] < peak){
                        len++;
                        bottom = nums[i];
                        next_peak = -next_peak;
                    }
                    if(nums[i] > peak){
                        peak = nums[i];
                    }
                }else{
                    if(nums[i] > pre){
                        peak = nums[i];
                        bottom = pre;
                        next_peak = -1;
                    }else{
                        bottom = nums[i];
                        peak = pre;
                        next_peak = 1;
                    }
                    len++;
                }
                pre = nums[i];
            }
            return len;
            
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
