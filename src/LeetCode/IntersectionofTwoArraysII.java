package LeetCode;

import java.util.*;

public class IntersectionofTwoArraysII {

    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums1.length; i++){
            map1.put(nums1[i], map1.getOrDefault(nums1[i], 0)+1);
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < nums2.length; i++){
            if(map1.getOrDefault(nums2[i], 0) > 0){
                list.add(nums2[i]);
                map1.put(nums2[i], map1.getOrDefault(nums2[i], 0)-1);
            } 
        }
        int[] res = new int[list.size()];
        for (int i = 0 ; i < res.length ; i++) res[i] = list.get(i);
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
