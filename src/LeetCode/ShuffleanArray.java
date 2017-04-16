package LeetCode;

import java.util.*;

public class ShuffleanArray {
    int[] nums;
    int[] sh_nums;
    Random r;

    public ShuffleanArray(int[] nums) {
        this.nums = nums;
        r = new Random();
        sh_nums = Arrays.copyOf(nums, nums.length);
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        sh_nums = Arrays.copyOf(nums, nums.length);
        return sh_nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int temp = 0; int r_i = 0;
        for(int i = 0; i< sh_nums.length; i++){
            r_i = r.nextInt(sh_nums.length-i)+i;
            temp = sh_nums[i];
            sh_nums[i] =sh_nums[r_i];
            sh_nums[r_i] = temp;
        }
        return sh_nums;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
