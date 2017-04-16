package LeetCode;

import java.util.HashMap;

public class FourSumII {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Long, Integer> map1 = new HashMap<Long, Integer>();
        long key = 0;
        for(int i = 0 ; i< A.length; i++){
            for(int j = 0; j < B.length; j++){
                key = (long)A[i]+B[j];
                map1.put(key, map1.getOrDefault(key, 0)+1);
            }
        }

        int count = 0;
        for(int i = 0 ; i< C.length; i++){
            for(int j = 0; j < D.length; j++){
                key = (long)C[i]+D[j];
                count+=map1.getOrDefault(0-key, 0);
            }
        }
        return count;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
