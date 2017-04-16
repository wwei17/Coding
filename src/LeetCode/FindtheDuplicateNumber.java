package LeetCode;

public class FindtheDuplicateNumber {

    public int findDuplicate(int[] nums) {
        int fast = 0; int slow = 0;
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(fast != slow);
        
        fast = 0;
        while(fast != slow){
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
