package LeetCode;

import java.util.HashMap;

public class CombinationSumIV {

    public int combinationSum4(int[] nums, int target) {
        return combinationSum4(nums, target, new HashMap<Integer, Integer>());
    }
    
    public int combinationSum4(int[] nums, int target, HashMap<Integer, Integer> map) {
        int n = 0;
        if(target < 0){
            
        }else if(target == 0){
            n = 1;
        }else if(map.containsKey(target)){
            n = map.get(target);
        }else{
            for(int i = 0; i < nums.length; i++){
                n += combinationSum4(nums, target - nums[i], map);
            }
            map.put(target, n);
        }
        
        return n;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
