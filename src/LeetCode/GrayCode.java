package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {

    public List<Integer> grayCode(int n) {
        int[] a = new int[n];
        for(int i = 0; i < n ; i++){
            a[i] = (int)Math.pow(2, i);
        }
        int b = 0;
        List<Integer> l = new ArrayList<Integer>();
        for(int i =0; i< Math.pow(2, n); i++){
            b = 0;
            for(int j = 0; j<n; j++){
                b |= (((a[j]+i)/(a[j]*2))%(2)) << j;
            }
            l.add(b);
        }
        return l;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
