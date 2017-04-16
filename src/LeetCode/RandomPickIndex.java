package LeetCode;

import java.util.*;

public class RandomPickIndex {

	HashMap<Integer, ArrayList<Integer>> map;
    Random r;
    public RandomPickIndex(int[] nums) {
        r = new Random();
        map = new HashMap<Integer, ArrayList<Integer>>();
        for(int i = 0 ; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                map.get(nums[i]).add(i);
            }else{
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(i);
                map.put(nums[i], list);
            }
        }
    }
    
    public int pick(int target) {
        ArrayList<Integer> a = map.get(target);
        return a.get(r.nextInt(a.size()));
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
