package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordBreak {

    public boolean wordBreak(String s, Set<String> dict) {
            
        boolean[] C = new boolean[s.length()+1];
        C[0] = true;
        for(int i = 0; i < s.length()+1; i++){
            for(int j = 0; j < i; j++){
                if(C[j] && dict.contains(s.substring(j,i))){
                    C[i] = true;
                }
            }
        }
        return C[s.length()];
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordBreak wb = new WordBreak();
		String[] ss = {"","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
		Set<String> setA = new HashSet<String>(Arrays.asList(ss));
		boolean result = wb.wordBreak("aaaaaaaaacaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", setA);
		System.out.println(result);
		
	}

}
