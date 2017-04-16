package LeetCode;

import java.util.Arrays;

public class MinimumMovestoEqualArrayElementsII {

    public int minMoves2(int[] nums) {

        int mid= findMid(nums);
        int count = 0;
        for(int i = 0 ; i < nums.length; i++){
            count += Math.abs(nums[i]-mid);
        }
        return count;
    }
    
    public int findMid(int[] nums){
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
