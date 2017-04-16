package LeetCode;

import java.util.Arrays;

public class CountPrimes {

    public int countPrimes(int n) {
        if(n <= 1) return 0;

        int temp = 0;
        boolean[] isPrime = new boolean[n-1];
        Arrays.fill(isPrime, true);
        for(int i = 2; i*2 <= n-1;i++){
            //if(isPrime[i-1]){
                for(int j = 2; j <= i && j*i<=n-1; j++){
                	isPrime[j*i-1] = false;
                }
            //}
            
        }
        
        int count = 0;
        for(int i = 0 ; i < n-1; i ++){
            if(isPrime[i]){
                count++;
                System.out.println(i+1+":P");
            }else{
            	System.out.println(i+1+":N");
            }
        }
        return count-1;
    }

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountPrimes cp = new CountPrimes();
		System.out.println(cp.countPrimes(21));
	}

}
