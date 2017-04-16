package LeetCode;

import java.util.*;

public class SplitArrayLargestSum {

    public int splitArray(int[] nums, int m) {
        long low = -1;
        long high = 0;
        for(int i = 0; i < nums.length; i++){
            high += nums[i];
            low = Math.max(low, nums[i]);
        }
        long mid = 0; int count = 1;
        long sum2 = 0;
        long max_sum = -1;
        long min_sum = high;
        while(low < high){
            max_sum = -1;
            sum2 = 0;
            count = 1;
            mid = (low+high)/2;
            for(int i = 0 ; i < nums.length; i++){
                sum2 +=nums[i];
                if(sum2 > mid){
                    max_sum = Math.max(max_sum, sum2 - nums[i]);
                    sum2 = nums[i];
                    count++;
                    if(count > m) i+=nums.length;
                }
            }
            if(count > m){
                low = mid+1;
            }else{
                high = mid;
                max_sum = Math.max(max_sum, sum2);
                min_sum = Math.min(min_sum, max_sum);
                
            }
        }
        return (int)min_sum;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SplitArrayLargestSum sln = new SplitArrayLargestSum();
		int[] a = new int[]{2,3,1,1,1,1,1};
		System.out.println(sln.splitArray(a, 5));
	}

}
