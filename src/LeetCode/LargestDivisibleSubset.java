package LeetCode;

import java.util.*;

public class LargestDivisibleSubset {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        int [] counts = new int[nums.length];
        Arrays.fill(counts, 1);
        int [] index = new int[nums.length];
        Arrays.fill(index, -1);
        Arrays.sort(nums);
        int max = 0 ; int max_i = -1;
        for(int i = 0; i < counts.length; i++){
            for(int j = i-1; j >=0 ; j--){
                if(nums[i]%nums[j] == 0 && counts[j]+1 > counts[i]){
                    counts[i] = counts[j]+1;
                    index[i] = j;
                }
            }
            if(counts[i] > max){
                max = counts[i];
                max_i = i;
            }
        }
        List<Integer> list = new LinkedList<Integer>();
        while(max_i != -1){
            list.add(0, nums[max_i]);
            max_i = index[max_i];
        }
        return list;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LargestDivisibleSubset sln = new LargestDivisibleSubset();
		List<Integer> list = sln.largestDivisibleSubset(new int[]{1,2,3});
		for(int i = 0 ; i < list.size(); i++){
			System.out.print(list.get(i)+" ");
		}
	}

}
