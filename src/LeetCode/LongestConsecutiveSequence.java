package LeetCode;

import java.util.HashMap;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] num) {
        HashMap<Integer, Integer> m = new HashMap<Integer,Integer>();
        
        for(int i = 0 ; i < num.length;i ++){
            m.put(num[i], 1);    
        }
        
        int max = 0; int len_forward, len_backward;
        for(int i = 0; i < num.length; i++){
            len_forward = 0;
            while(m.containsKey(num[i]+len_forward+1)){
                m.remove(num[i]+len_forward+1);
                len_forward++;
            }
            len_backward = 0;
            while(m.containsKey(num[i]-len_backward-1)){
                m.remove(num[i]-len_backward-1);
                len_backward++;
            }
            m.remove(num[i]);
            if(len_forward+len_backward + 1 > max) {
                max = len_forward+len_backward +1;
            }
        }
        return max;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
