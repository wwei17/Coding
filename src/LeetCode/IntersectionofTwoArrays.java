package LeetCode;

import java.util.HashSet;

public class IntersectionofTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<Integer>();
        HashSet<Integer> set2 = new HashSet<Integer>();
        for(int i = 0 ; i <nums1.length; i++){
            set1.add(nums1[i]);
        }
        for(int i = 0; i < nums2.length; i++){
            if(set1.contains(nums2[i]))set2.add(nums2[i]);
        }
        int [] res = new int[set2.size()];
        int i = 0;
        for(int val : set2){
            res[i] = val;
            i++;
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
