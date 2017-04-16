package LeetCode;

import java.util.*;

public class FindAllAnagramsinaString {

    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        char c = ' ';
        for(int i = 0; i < p.length(); i++){
            c = p.charAt(i);
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            }else{
                map.put(c,1);
            }
        }
        List<Integer> list = new ArrayList<Integer>();
        for(int i = s.length()-1 , j = p.length(); i >= 0; i--){
            c = s.charAt(i);
            if(map.containsKey(c)){
                map.put(c, map.get(c)-1);
            }else{
                map.put(c,1);
            }
            if(map.get(c) == 0) map.remove(c);
            if(i + j < s.length()){
                c = s.charAt(i+j);
                if(map.containsKey(c)){
                    map.put(c, map.get(c)-1);
                }else{
                    map.put(c,1);
                }
                if(map.get(c) == 0) map.remove(c);
            }

            if(map.size() == 0) list.add(i);
        }
        return list;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
