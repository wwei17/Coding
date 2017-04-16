package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        StringBuffer s = new StringBuffer();
        List<String> results = new ArrayList<String>();
        int flag = 0;
        for(int i = 0; i < nums.length; i++){
            if(i == 0){
                s.append(nums[i]);
            }else if(nums[i] - nums[i-1] == 1){
                flag = 1;
            }else if(flag == 1){
                s.append("->"+nums[i-1]);
                flag = 0;
                results.add(s.toString());
                s = new StringBuffer(""+nums[i]);
            }else{
                results.add(s.toString());
                s= new StringBuffer(""+nums[i]);
                flag = 0;
            }
        }
        if(flag == 1){
            s.append("->"+nums[nums.length-1]);
            results.add(s.toString());
        }else if(s.length()>0){
            results.add(s.toString());
        }
        return results;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
