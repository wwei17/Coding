package LeetCode;

import java.util.*;

public class LongestUncommonSubsequenceII {

    public int findLUSlength(String[] strs) {
    	int max = 0;
    	HashMap<Integer, HashMap<String, Integer>> map = new HashMap<Integer, HashMap<String, Integer>>();
    	for(int i = 0 ; i < strs.length; i++){
    		int l = strs[i].length();
    		map.putIfAbsent(l, new HashMap<String, Integer>());
    		map.get(l).put(strs[i], map.get(l).getOrDefault(strs[i], 0)+1);
    		max = Math.max(max, l);
    	}
    	HashSet<String> set = new HashSet<String>();
    	for(int i = 10 ; i > 0; i--){
    		HashMap<String, Integer> smap = map.getOrDefault(i, new HashMap<String, Integer>());
	    	for(String s: smap.keySet()){
	    		if(smap.get(s) == 1){
	    			boolean flag = false;
	    			for(String ss: set){
	    				flag = isSub(s, ss) || flag;
	    			}
	    			if(!flag){
	    				return s.length();
	    			}
	    		}
	    		set.add(s);
	    	}
    	}
        return -1;
    }
    
    public boolean isSub(String small, String big){
    	int j = 0;
    	for(int i = 0; i < big.length() && j < small.length(); i++){
    		if(big.charAt(i) == small.charAt(j)){
    			j++;
    		}
    	}
    	
    	return j == small.length();
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestUncommonSubsequenceII sln = new LongestUncommonSubsequenceII();
		System.out.println(sln.findLUSlength(new String[]{"aaa","aaa","aa"}));
	}

}
