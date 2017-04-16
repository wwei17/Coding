package LeetCode;

import java.util.*;

public class FindAllDuplicatesinanArray {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0 ; i < nums.length; i++){
            int j = Math.abs(nums[i])-1;
            if(nums[j] > 0){
                nums[j] = -nums[j];
            }else{
                list.add(j+1);
            }
        }
        return list;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
