package LeetCode;

public class TotalHammingDistance {

    public int totalHammingDistance(int[] nums) {
        int[] count = new int[2] ;
        int res = 0;
        for(int i = 0 ; i < 32; i++){
            count[0] = 0 ; count[1] = 0;
            for(int j= 0 ; j < nums.length; j++){
                count[(nums[j] >> i)&1] ++;
            }
            res+= count[0]*count[1];
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
