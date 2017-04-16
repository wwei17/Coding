package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class RemoveDuplicateLetters {

    public String removeDuplicateLetters(String s) {
        HashMap<Character, ArrayList<Integer>> map = new HashMap<Character, ArrayList<Integer>>();
        char c = ' ';
        ArrayList<Character> letters = new ArrayList<Character>();
        for(int i = 0 ; i < s.length(); i++){
            c = s.charAt(i);
            if(!map.containsKey(c)){
                map.put(c, new ArrayList<Integer>());
                letters.add(c);
            }
            map.get(c).add(i);
        }
        Collections.sort(letters);
        char c2; int lastIndex; int minIndex = 0;
        ArrayList<Integer> temp;
        StringBuffer sb = new StringBuffer();
        while(letters.size() > 0){
            for(int i = 0 ; i < letters.size(); i++){
                c = letters.get(i);
                while(map.get(c).get(0) < minIndex) map.get(c).remove(0);
                int index = map.get(c).get(0);
                boolean found = true;
                for(int j = 0 ; j < letters.size(); j++){
                    if(i != j){
                        c2 = letters.get(j);
                        temp = map.get(c2);
                        lastIndex = temp.get(temp.size()-1);
                        if(lastIndex < index) {
                            found = false;
                            break;
                        }
                    }
                }
                if(found){
                    letters.remove(i);
                    break;
                }
            }
            sb.append(c);
            minIndex = map.get(c).get(0);
            map.remove(c);
            
        }
        return sb.toString();
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveDuplicateLetters sln = new RemoveDuplicateLetters();
		System.out.println(sln.removeDuplicateLetters("cbacdcbc"));
	}

}
