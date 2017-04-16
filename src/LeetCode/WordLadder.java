package LeetCode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
    public int ladderLength(String start, String end, Set<String> dict) {
        if(start.length() != end.length()) return 0;
        
        
        Queue<String> q = new LinkedList<String>();
        q.add(start);
        dict.remove(start);
        int l = 0;
        while(q.size() != 0){
            int count = q.size();
            String s;
            for(int i = 0; i < count; i++){
                s = q.remove();
                char[] cs = s.toCharArray();
                for(int j = 0; j < s.length(); j++){
                    char a = cs[j];
                    for(char k = 'a'; k <= 'z'; k++){
                        cs[j] = k;
                        
                        String ss = new String(cs);
                        if(ss.equals(end)){
                            return l+2;
                        }
                        
                        if(dict.contains(ss)){
                            q.add(ss);
                            dict.remove(ss);
                        }
                        
                    }
                    cs[j] = a;
                }
            }
            l++;
        }
        return 0;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
