package LeetCode;

public class SortColors {

    public void sortColors(int[] A) {
        int start = 0;
        int end = A.length-1;
        for(int i = 0; i <= end; i++){
            if(A[i] == 0){
                swap(A,start, i);
                start ++;
            }
            if(A[i] == 2){
                while(end >= i && A[end] == 2){
                    end--;
                }
                if(end < i){
                    break;
                }
                swap(A,end, i);
                end--;
                if(A[i] == 0){
                    swap(A,start, i);
                    start ++;
                }
            }
        }
    }
    
    public void swap(int []A, int p1, int p2){
        int temp = A[p1];
        A[p1] = A[p2];
        A[p2] = temp;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
