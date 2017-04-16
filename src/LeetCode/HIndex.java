package LeetCode;

public class HIndex {
	
    public int hIndex(int[] citations) {
        int n = citations.length;
        int [] a = new int[n+1];
        for(int i = 0; i < n; i++){
            if(citations[i] >= n){
                a[n]++;
            }else{
                a[citations[i]]++;
            }
        }
        
        for(int i = 0; i < n+1; i++){
            if(i > 0){
                a[n-i] += a[n-i+1];
            }
            if(a[n-i] >= n-i){
                return n-i;
            }
        }
        return 0;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
