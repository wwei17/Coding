package LeetCode;

public class RotateArray {

    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        if(k>0){
            rotate(0, nums.length-1, nums);
            rotate(0, k-1, nums);
            rotate(k, nums.length-1, nums);
        }
    }
    
    public void rotate(int start, int end, int[] a){
        int temp = 0;
        for(;start < end; start++, end--){
            temp = a[start];
            a[start] = a[end];
            a[end] = temp;
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
