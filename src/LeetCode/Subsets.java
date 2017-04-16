package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {

    public List<List<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        
        int n = (int)Math.pow(2, S.length);
        int[] a = new int[n];
        List<List<Integer>> l = new ArrayList<List<Integer>>();
        for(int i =0; i< n; i++){
            List<Integer> ll = new ArrayList<Integer>();
            for(int j = 0; j < S.length; j++){
                if((i>>j)%2 == 1){
                    ll.add(S[j]);
                }
            }
            l.add(ll);
        }
        return l;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
