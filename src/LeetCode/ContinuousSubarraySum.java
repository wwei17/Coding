package LeetCode;

import java.util.HashMap;

public class ContinuousSubarraySum {

    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int sum = 0;
        map.put(0, -1);
        for(int i = 0; i < nums.length; i++){
            sum = (sum+nums[i]);
            if(k!=0) sum %= k;
            if(i- map.getOrDefault(sum, 10000) > 1) return true;
            map.putIfAbsent(sum, i);
        }
        return false;

    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
