package LeetCode;

public class RemoveDuplicatesfromSortedArrayII {

    public int removeDuplicates(int[] A) {
        if(A.length == 0) return 0;
        int i = 0;
        int j = 1;
        int count = 0;
        while(j < A.length){
            if(A[i] != A[j]){
                i++;
                A[i] = A[j];
                count = 0;
            }else if(A[i] == A[j] && count == 0){
                i++;
                if(i < A.length){
                    A[i] = A[j];
                }else{
                    return i;
                }
                count ++;
            }else{
                count ++;
            }
            j++;
        }
        return i+1;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
