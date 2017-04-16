package LeetCode;

import java.util.HashMap;

public class PredicttheWinner {

    public boolean PredictTheWinner(int[] nums) {
        int score = PredictTheWinner(nums, 0, nums.length-1, new HashMap<Integer, Integer>(), true);
        int sum = 0;
        for(int a : nums){sum+=a;}
        return score >= (sum+1)/2;
    }
    
    public int PredictTheWinner(int[] nums, int start, int end, HashMap<Integer, Integer> map, boolean myTurn){
        int key = (start<<5)|end;
        if(map.containsKey(key)){
            return map.get(key);
        }else if(start <= end){
            int max1=0 , max2=0, max = 0;
            if(myTurn){
                max1 = PredictTheWinner(nums, start+1, end, map, !myTurn)+nums[start];
                max2 = PredictTheWinner(nums, start, end-1, map, !myTurn)+nums[end];
                max = Math.max(max1, max2);
            }else{
                max1 = PredictTheWinner(nums, start+1, end, map, !myTurn);
                max2 = PredictTheWinner(nums, start, end-1, map, !myTurn);
                max = Math.min(max1, max2);
            }
           
            map.put(key, max);
            return max;
        }else{
            return 0;
        }
    }
    
	public static void main(String[] args) {
		PredicttheWinner sln = new PredicttheWinner();
		int[] a = new int[]{1,5,2};
		System.out.println(sln.PredictTheWinner(a));
		
	}

}
