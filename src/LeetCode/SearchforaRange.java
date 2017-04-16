package LeetCode;

public class SearchforaRange {

    public int[] searchRange(int[] A, int target) {
        int start = 0;
        int end = A.length-1;
        int mid;
        
        int start_p = -1;
        int end_p = -1;
        
        while(end - start > 1){
            mid = (start + end)/2;
            if(target > A[mid]){
                start = mid;
            }else{
                end = mid;
            }
        }
        if(A[start] == target){
            start_p = start;
        }else if(A[end] == target){
            start_p = end;
        }

        start = 0;
        end = A.length-1;
        while(end - start > 1){
            mid = (start + end)/2;
            if(target < A[mid]){
                end = mid;
            }else{
                start = mid;
            }
        }
        if(A[end] == target){
            end_p = end;
        }else if(A[start] == target){
            end_p = start;
        }
        
        return new int[]{start_p, end_p};
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
