package LeetCode;

public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0; int curr = 0;
        for(int a : nums){
            if(a == 0 ){
                curr = 0;
            }else{
                curr++;
            }
            if(max < curr)max = curr;
        }
        return max;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
