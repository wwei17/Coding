package LeetCode;

import java.util.ArrayList;
import java.util.Collections;

public class LongestIncreasingSubsequence {

	public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int i_temp = -1;
        for(int i = 0; i < nums.length; i++){
            if(list.size() == 0 || list.get(list.size()-1) < nums[i]){
                list.add(nums[i]);
            }else{
                i_temp = Collections.binarySearch(list, nums[i]);
                if(i_temp<0){
                    list.set(-i_temp-1, nums[i]);
                }
            }
        }
        return list.size();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
