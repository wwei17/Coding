package LeetCode;

public class RemoveElement {

    public int removeElement(int[] A, int elem) {
        int i =0;
        int j = A.length - 1;
        while(i <= j){
            while(i <= j && A[i] != elem){
                i++;
            }
            
            while(i <= j && A[j] == elem){
                j--;
            }
            if(i < j){ 
                A[i] = A[j];
                j--; i++;
            }
        }
        return i;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
