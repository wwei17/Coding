package LeetCode;

import java.util.ArrayList;

public class ZigZagConversion {

    public String convert(String s, int nRows) {
        if(nRows <= 1) return s;
        
        ArrayList[] a = new ArrayList[nRows];
        for(int i = 0; i < nRows; i++){
            a[i] = new ArrayList<Character>();
        }
        
        
        for(int i = 0; i < s.length(); i++){
            a[getJ(i,2*nRows-2)].add(s.charAt(i));
        }
        
        StringBuffer ss = new StringBuffer("");
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a[i].size(); j++){
                ss.append(a[i].get(j));
            }
        }
        return ss.toString();
    }
    
    public int getJ(int x, int n){
        int k = x % n;
        if(0 <= k && k <= n/2){
            return k;
        }else{
            return n-k;
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
