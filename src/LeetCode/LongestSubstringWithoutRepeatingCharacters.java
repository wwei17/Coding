package LeetCode;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        HashMap map = new HashMap<Character, Object>();
        int max = 0;
        
        int start = 0; 
        int end = 0;
        while(end < s.length()){
            char c = s.charAt(end);
            if(!map.containsKey((Character)c)){
                map.put((Character)c,1);
                end++;
            }else{
                map.remove((Character)s.charAt(start));
                start++;
            }
            if(map.size() > max){
                max = map.size();
            }
        }
        return max;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
