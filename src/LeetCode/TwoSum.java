package LeetCode;

import java.util.HashMap;

public class TwoSum {

    public int[] twoSum(int[] numbers, int target) {
        int[] index = new int[2];
        HashMap map = new HashMap<Integer, Integer>();
        
        for(int i =0; i< numbers.length; i++){
            if(map.containsKey(numbers[i])){
                index[0] = (int)map.get(numbers[i]) + 1;
                index[1] = i + 1;
            }else{
                map.put(target-numbers[i],i);

            }
        }
        return index;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
