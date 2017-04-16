package LeetCode;

import java.util.HashSet;

public class PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        if(sum%2 == 1) return false;
        HashSet<Integer> set = new HashSet<Integer>();
        set.add(0);
        for(int i = 0; i < nums.length; i++){
            int remaind = sum/2-nums[i];
            if(set.contains(remaind)){
                return true;
            }else{
                HashSet<Integer> set2 = new HashSet<Integer>();
                for(int a: set){
                    set2.add(a+nums[i]);
                }
                set.addAll(set2);
            }
        }
        return false;
        
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
