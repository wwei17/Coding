package LeetCode;

import java.util.*;

public class IncreasingSubsequences {

    public List<List<Integer>> findSubsequences(int[] nums) {
        HashMap<String, List<Integer>> map = new HashMap<String, List<Integer>>();
        for(int i = 0 ; i < nums.length; i++){
            String key = nums[i]+",";
            HashMap<String, List<Integer>> map2 = new HashMap<String, List<Integer>>();
            for(String s: map.keySet()){
                List<Integer> list = map.get(s);
                if(list.get(list.size()-1) <= nums[i] && !map.containsKey(s+key)){
                    List<Integer> newList = new ArrayList<Integer>(list);
                    newList.add(nums[i]);
                    map2.put(s+key, newList);
                }
            }
            map.putAll(map2);
            if(!map.containsKey(key)){
                List<Integer> newList = new ArrayList<Integer>();
                newList.add(nums[i]);
                map.put(key,newList);
            }
        }
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(String s: map.keySet()){
            List<Integer> list = map.get(s);
            if(list.size() > 1){
                res.add(list);
            }
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
