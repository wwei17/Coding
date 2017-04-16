package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakII {
    public List<String> wordBreak(String s, Set<String> dict) {
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>();
        boolean[] B = new boolean[s.length()+1];
        B[0] = true;
        
        for(int i = 1; i < B.length; i++){
            
            for(int j =0; j < i; j++){
                if(B[j] && dict.contains(s.substring(j,i))){
                    B[i] = true;
                    ArrayList<Integer> li = null;
                    if(map.containsKey(i)){
                        li = map.get(i);
                    }else{
                        li = new ArrayList<Integer>();
                    }
                    li.add(j);
                    map.put(i, li);
                }
            }
        }
        
        if(map.containsKey(s.length())){
            
            
            return getStringFromMap(s,map,s.length());
        }else{
            return new ArrayList<String>();
        }
    }
    
    private ArrayList<String> getStringFromMap(String s,HashMap<Integer,ArrayList<Integer>> map, int key){
        ArrayList<String> ss= new ArrayList<String>();
        if(map.containsKey(key)){
            ArrayList<Integer> l = map.get(key);
            
            for(int i = 0; i<l.size() ; i++){
                ArrayList<String> temp= getStringFromMap(s,map,l.get(i));
                if(temp.size() == 0){
                    ss.add(s.substring(l.get(i),key));
                }else{
                    for(int j = 0 ; j < temp.size(); j ++){
                        ss.add(temp.get(j)+ " " + s.substring(l.get(i),key));    
                    }
                }
            }
        }else{

        }
        return ss;
    }
    
	public static void main(String[] args) {
		WordBreakII wb = new WordBreakII();
		String[] ss = {"cat", "cats", "and", "sand", "dog"};
		Set<String> setA = new HashSet<String>(Arrays.asList(ss));
		ArrayList<String> result = (ArrayList<String>) wb.wordBreak("catsanddog", setA);
		for(int i = 0 ; i < result.size(); i++)
			System.out.println(result.get(i));
	}

}
