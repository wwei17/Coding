package LeetCode;

public class MaximumProductSubarray {

    public int maxProduct(int[] A) {
        int[] maxs = new int[A.length];
        int[] mins = new int[A.length];
        
        maxs[0] = A[0];
        mins[0] = A[0];
        int max = A[0];
        for(int i = 1 ; i< A.length; i++){
            maxs[i] = Math.max(Math.max(maxs[i-1]*A[i],mins[i-1]*A[i]),A[i]);
            mins[i] = Math.min(Math.min(maxs[i-1]*A[i],mins[i-1]*A[i]),A[i]);
            if(max < maxs[i]){
                max = maxs[i];
            }
        }
        return max;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
