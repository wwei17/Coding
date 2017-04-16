package LeetCode;

import java.util.*;

public class ReverseVowelsofaString {

    public String reverseVowels(String s) {
        int i1 = 0; int i2 = s.length()-1;
        StringBuilder sb = new StringBuilder();
        char c = ' ';
        HashSet<Character> set = new HashSet<Character>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        while(i1 < s.length()){
            c = s.charAt(i1);
            if(set.contains(c)){
                c = s.charAt(i2);
                while(!set.contains(c)){
                    i2--;
                    c = s.charAt(i2);
                }
                i2--;
            }
            sb.append(c);
            i1++;
        }
        return sb.toString();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
