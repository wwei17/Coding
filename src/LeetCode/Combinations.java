package LeetCode;

import java.util.*;

public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        int [] A = new int[k];
        List<List<Integer>> ll = new ArrayList<List<Integer>>();
        for(int i = 0 ; i < k; i++){
            A[i] = i+1;
        }
        
        boolean stop = false;
        do{
            List<Integer> l = new ArrayList<Integer>();
            for(int i = 0; i < k; i++){
                l.add(A[i]);
            }
            ll.add(l);
            
            int j = k-1;
            A[j]++;
            if(A[j] > n){
                do{
                    j--;
                    if(j < 0) {
                        return ll;
                    }else{
                        A[j]++;
                    }
                }while(A[j] > n-k+j+1);
                j++;
                while(j < k){
                    A[j] = A[j-1]+1;
                    j++;
                }
            }
        }while(!stop);
        return ll;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
