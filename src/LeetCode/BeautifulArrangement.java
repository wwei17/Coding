package LeetCode;

public class BeautifulArrangement {

    public int countArrangement(int N) {
        int [] a = new int[N];
        for(int i = 0 ; i < N; i++){
            a[i] = i+1;
        }
        return countHelper(a, N);
    }
    
    public int countHelper(int[] a, int n){
        if(n == 0){
            return 1;
        }
        int count = 0;
        for(int i = 0 ;i < n; i++){
            if((a[i]%n == 0 || n%a[i]==0)){
            	if(!(a[n-1]%(i+1)==0 || (i+1)%a[n-1]==0)){
            		int b = 0;
            	}
                swap(a, n-1, i);
                count +=countHelper(a, n-1);
                swap(a, i, n-1);
            }
        }
        return count;
    }
    
    private void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BeautifulArrangement sln = new BeautifulArrangement();
		System.out.println(sln.countArrangement(6));
	}

}
