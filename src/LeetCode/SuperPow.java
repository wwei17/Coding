package LeetCode;

import java.util.HashMap;

public class SuperPow {

    public int superPow(int a, int[] b) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int m1 = 1;
        a = a%1337;
        for(int i = 0 ; i < 10; i++){
            map.put(i, m1);
            m1 = (m1*a)%1337;
        }
        int res = 1;
        for(int i = 0 ;i <b.length; i++){
            m1 = map.get(b[b.length-1-i]);
            for(int c : map.keySet()){
                int m2 = 1;
                int a2 = map.get(c);
                for(int j = 0 ; j < 10; j++){
                    m2 = (m2*a2)%1337;
                }
                map.put(c, m2);
            }
            res = (res*m1)%1337;
        }
        return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SuperPow sln = new SuperPow();
		System.out.println(sln.superPow(2, new int[]{1,0}));
		
	}

}
