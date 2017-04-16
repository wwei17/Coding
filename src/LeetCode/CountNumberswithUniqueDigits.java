package LeetCode;

import java.util.HashMap;

public class CountNumberswithUniqueDigits {

    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0) return 1;
        if(n == 1) return 10;
        if(n == 2) return 91;
        if(n > 10) return 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        return countNumbersWithUniqueDigits(n-1)+9*fact(n, map);
    }
    
    public int fact(int n, HashMap<Integer, Integer> map){
        if(map.containsKey(n)) return map.get(n);
        int res = 1;
        n--;
        while(n > 0){
            res *= (10-n);
            n--;
        }
        map.put(n, res);
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
