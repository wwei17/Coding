package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedinanArray {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int a1  = 0; int a2 = 0;
        for(int i = 0 ; i < nums.length; i++){
            a1 = i; a2 = nums[a1]-1;
            while(nums[a1] != a1+1 && nums[a2] != nums[a1]){
                nums[a1] = nums[a1]^nums[a2];
                nums[a2] = nums[a1]^nums[a2];
                nums[a1] = nums[a1]^nums[a2];
                a2 = nums[a1]-1;
            }
        }
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0 ; i < nums.length; i++){
            if(nums[i] != i+1){
                list.add(i+1);
            }
        }
        return list;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
