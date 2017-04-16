package LeetCode;

import java.util.*;

public class RelativeRanks {

    public String[] findRelativeRanks(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(/*(a,b) -> b - a*/);
        for(int i = 0 ; i < nums.length; i++){
            map.put(nums[i], i);
            pq.offer(nums[i]);
        }
        String [] rank = new String[nums.length];
        for(int i = 1; i <= nums.length ; i++){
            if( i == 1) rank[map.get(pq.poll())] = "Gold Medal";
            else if( i == 2) rank[map.get(pq.poll())] = "Silver Medal";
            else if( i == 3)rank[map.get(pq.poll())] = "Bronze Medal";
            else rank[map.get(pq.poll())] = i+"";
        }
        
        
        
        return rank;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
