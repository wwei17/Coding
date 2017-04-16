package LeetCode;

import java.util.List;

public class LongestWordinDictionarythroughDeleting {

    public String findLongestWord(String s, List<String> d) {
        String max = "";
        for(String s1 : d){
            int j = 0;
            for(int i = 0; i < s.length(); i++){
                if(j < s1.length() && s.charAt(i) == s1.charAt(j)) j++;
            }
            if (j == s1.length() && ((j == max.length() && s1.compareTo(max) < 0) || j > max.length())) max = s1;
        }
        return max;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
