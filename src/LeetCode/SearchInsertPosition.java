package LeetCode;

public class SearchInsertPosition {

    public int searchInsert(int[] A, int target) {
        int end = A.length -1;
        int start = 0;
        int i = 0;
        while(true){
            i = (start + end) /2;
            if(A[i] == target){
                return i;
            }else{
                if(A[i] < target){
                    if(i == A.length -1 || target < A[i+1]){
                        return i + 1;
                    }
                    start = i + 1;
                }else{
                    if(i == 0 || A[i - 1] < target){
                        return i;
                    }
                    end = i - 1;
                }
            }
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
