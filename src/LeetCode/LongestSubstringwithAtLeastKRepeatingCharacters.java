package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;

public class LongestSubstringwithAtLeastKRepeatingCharacters {

	public int longestSubstring(String s, int k) {
        return longestSubstringRes(s, k, 0, s.length()-1);
    }
    
    public int longestSubstringRes(String s, int k, int start, int end){
        if(end < start) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        char c = ' ';
        for(int i = start; i <= end; i++){
            c = s.charAt(i);
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else{
                map.put(c,1);
            }
        }
        int max_len = Integer.MIN_VALUE;
        int len = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = start; i <= end; i++){
            c = s.charAt(i);
            if(map.get(c) < k) list.add(i);
        }
        list.add(end+1);
        if(list.size()==1){
            return end - start +1;
        }else{
            int p1 = start; int p2 = 0;
            for(int i = 0; i < list.size(); i++){
                p2 = list.get(i);
                len = longestSubstringRes(s, k, p1, p2-1);
                p1 = p2+1;
                max_len = Math.max(max_len, len);
            }
            return max_len;
        }
        
        
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestSubstringwithAtLeastKRepeatingCharacters sln = new LongestSubstringwithAtLeastKRepeatingCharacters();
		System.out.println(sln.longestSubstring("bbaaacbd", 3));
	}

}
