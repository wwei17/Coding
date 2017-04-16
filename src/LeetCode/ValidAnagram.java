package LeetCode;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        int[] res = new int[26];
        int count = 0;
        for(int i = 0 ; i < s.length(); i++){
            res[s.charAt(i)-'a']++;
            res[t.charAt(i)-'a']--;
        }
        for(int i = 0 ; i < 26; i++){
            count +=res[i]&0x0fffffff;
        }
        return count == 0;
    }
}
