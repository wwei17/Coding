package LeetCode;

import java.util.*;

public class LetterCombinationsofaPhoneNumber {

    public List<String> letterCombinations(String digits) {
        String[] key2= {"a","b","c"};
        String[] key3= {"d","e","f"};
        String[] key4= {"g","h","i"};
        String[] key5= {"j","k","l"};
        String[] key6= {"m","n","o"};
        String[] key7= {"p","q","r","s"};
        String[] key8= {"t","u","v"};
        String[] key9= {"w","x","y","z"};
        String[] key0= {" "};
        String[] key_s= {"+"};
        ArrayList<Object> a = new ArrayList<Object>();
        ArrayList<String> ss = new ArrayList<String>();
        if(digits == null || digits.length() == 0){ 
        	ss.add("");
        	return ss;
        }
        
        for(int i = 0; i < digits.length(); i++){
            if(digits.charAt(i) == '2'){
                a.add(key2);
            }else if(digits.charAt(i) == '3'){
                a.add(key3);
            }else if(digits.charAt(i) == '4'){
                a.add(key4);
            }else if(digits.charAt(i) == '5'){
                a.add(key5);
            }else if(digits.charAt(i) == '6'){
                a.add(key6);
            }else if(digits.charAt(i) == '7'){
                a.add(key7);
            }else if(digits.charAt(i) == '8'){
                a.add(key8);
            }else if(digits.charAt(i) == '9'){
                a.add(key9);
            }else if(digits.charAt(i) == '*'){
                a.add(key_s);
            }else if(digits.charAt(i) == '0'){
                a.add(key0);
            }
        }
        ArrayList<Integer> b = new ArrayList<Integer>();
        String[] key = null;
        for(int i =0; i < a.size(); i++){
            key = (String[])a.get(i);
            b.add(key.length);
        }
        
        
        StringBuffer sb = new StringBuffer();
        int i = 0; int k = 0;
        while(i >= 0){
        	
        	if(i == a.size()) {
        		ss.add(sb.toString());
        		sb.delete(sb.length()-1, sb.length());
        		i--;
        	}else{
        		k = b.get(i)-1;
        		if(k < 0){
        	
	    			b.set(i,((String[])a.get(i)).length);
	    			if(sb.length() > 0)
	    			    sb.delete(sb.length()-1, sb.length());
	    			i--;
	        	}else{
	        		sb.append(((String[])a.get(i))[k]);
		        	b.set(i,k);
		        	i++;
	
	        	}
        	}
        }
        
        return ss;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
