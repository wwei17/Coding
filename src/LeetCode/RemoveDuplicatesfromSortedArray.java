package LeetCode;

public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] A) {
        if(A.length == 0) return 0;
        int i = 0;
        int j = 0;
        while(j<A.length){
            if(A[i] != A[j]){
                i++;
                A[i] = A[j];
            }
            j++;
        }
        
        return i+1;
        
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
