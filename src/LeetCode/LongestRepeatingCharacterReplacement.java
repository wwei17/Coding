package LeetCode;

import java.util.*;

public class LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {
        int[] index = new int[s.length()];
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = s.length()-1 ; i >=0; i--){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                index[i] = map.get(c);
            }
            map.put(c, i);
        }
        int max_ll = 0;
        for(char c: map.keySet()){
            int i = map.get(c);
            int sum_l = 1;
            int sum_k = 0;
            LinkedList<Integer> k_q = new LinkedList<Integer>();
            LinkedList<Integer> l_q = new LinkedList<Integer>();
            int max_l = 1;
            while(index[i] != 0){
                int next_i = index[i];
                int interval = next_i - i - 1;
                sum_k += interval;
                k_q.offer(interval);
                sum_l += interval+1;
                l_q.offer(interval+1);
                while(sum_k > k){
                    sum_k -= k_q.poll();
                    sum_l -= l_q.poll();
                }
                max_l =Math.max(sum_l, max_l);
                i = next_i;
            }
            max_l = Math.max(sum_l+Math.min(k-sum_k, index.length-1-i+map.get(c)), max_l);
            max_ll =Math.max(max_ll, max_l);
        }
        return max_ll;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestRepeatingCharacterReplacement sln = new LongestRepeatingCharacterReplacement();
		System.out.println(sln.characterReplacement("ABBCCCABAB",4));
	}

}
