package LeetCode;

public class MergeSortedArray {

    public void merge(int A[], int m, int B[], int n) {
        int ia = m-1;
        int ib = n-1;
        int i = m+n-1;
        while(ia >=0 && ib >= 0){
            if(A[ia] < B[ib]){
                A[i] = B[ib];
                ib --;
            }else{
                A[i] = A[ia];
                ia --;
            }
            i--;
        }
        
        while(ib >= 0){
            A[i] = B[ib];
            ib --;
            i--;
        }

    
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
