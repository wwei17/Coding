package LeetCode;

import java.util.*;

public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        StringBuffer sb = new StringBuffer();
        String separator = "";
        for(int i = 0 ; i < s.length(); i++){
        	sb.append(separator);
            sb.append(s.charAt(i));
            separator = "#";
        }
        String ss = sb.toString();
        List<List<Integer>> count = new ArrayList<List<Integer>>();
        for(int i = 0 ; i < ss.length();i++){
        	List<Integer> c = new ArrayList<Integer>();
        	c.add(i);
        	if(i > 0){
        		for(int j = 0 ; j <count.get(i-1).size(); j++ ){
        			int k = count.get(i-1).get(j);
        			if(k >0 && ss.charAt(k-1) == ss.charAt(i)){
        				c.add(k-1);
        			}
        		}	
        	}
        	count.add(c);
        }
        //printArrayList(count);
        
        StringBuffer sb2 = new StringBuffer();
        for(int i = ss.length()-1 ; i >= 0 ;i--){
        	if(i%2 == 0){
        		for(int j = 0 ; j < count.get(i).size(); j++){
        			count.get(i).set(j,count.get(i).get(j)/2);
        		}
        	}else{
        		count.remove(i);
        	}
        }
        
        printArrayList(count);
        Stack<Integer> st = new Stack<Integer>();
        int[] k = new int[s.length()];
        for(int i = 0; i < k.length; i++){
        	k[i] = count.get(i).size();
        }
        if(count.size()>0){
        	st.push(k.length -1);
        }
        ArrayList<String> temp_s = new ArrayList<String>();
        int index = k.length-1;
        int temp;
        List<List<String>> ll = new ArrayList<List<String>>();
        while(st.size()>0){
        	index = st.peek();
        	if(index >=0 && k[index] > 0){
	        	temp = count.get(index).get(k[index]-1);
	        	k[index]--;
	        	temp_s.add(0,s.substring(temp, index+1));
	        	
	        	st.push(temp - 1);
	        	if(temp == 0){
	        		List<String> l = new ArrayList<String>();
	        		for(int i = 0; i <temp_s.size(); i++){
	        			l.add(temp_s.get(i));
	        		}
	        		ll.add(l);
	        	}
        	}else{
        		st.pop();
        		if(temp_s.size()>0) temp_s.remove(0);
        		if(index>=0) k[index] = count.get(index).size();
        	}
        }
        
        return ll;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PalindromePartitioning s = new PalindromePartitioning();
		s.printArrayListString(s.partition("aabaa"));

	}

	
	void printArrayList(List<List<Integer>> c){
		for(int i = 0 ; i <c.size(); i++){
			for(int j = 0 ; j < c.get(i).size(); j++){
				System.out.print(c.get(i).get(j)+" ");
			}
			System.out.println();
		}
	}
	
	void printArrayListString(List<List<String>> ss){
		for(int i = 0 ; i <ss.size(); i++){
			for(int j = 0 ; j < ss.get(i).size(); j++){
				System.out.print(ss.get(i).get(j)+" ");
			}
			System.out.println();
		}
	}
}
