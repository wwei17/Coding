package LeetCode;

import java.util.HashMap;

public class TargetSum {

    public int findTargetSumWays(int[] nums, int S) {
        return findTargetSumWays(nums, S, 0, new HashMap<Integer, Integer>());
    }
    
    public int findTargetSumWays(int[] nums, int S, int index, HashMap<Integer, Integer> map) {
        int key = (S << 5) | index;
        if(map.containsKey(key)){
            return map.get(key);
        }if(index < nums.length){
            int res = findTargetSumWays(nums, S-nums[index], index+1, map)+findTargetSumWays(nums, S+nums[index], index+1, map);
            map.put(key, res);
            return res;
        }else{
            return S==0?1:0;
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
