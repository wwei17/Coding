package LeetCode;

import java.util.*;

public class RemoveInvalidParentheses {

	public List<String> removeInvalidParentheses(String s) {
        HashSet<String> que = new HashSet<String>();
        HashSet<String> que2 = new HashSet<String>();
        HashSet<String> list = new HashSet<String>();
        que.add(s);
        String temp;
        if(checkValid(s)) list.add(s);
        while(que.size() > 0 && list.size() == 0){
            for(String str : que){
                for(int i = 0 ; i< str.length(); i++){
                    if(str.charAt(i) == '(' || str.charAt(i) == ')'){
                        if(i == 0){
                            temp = str.substring(i+1);
                        }else{
                            temp = str.substring(0, i)+str.substring(i+1, str.length());
                        }
                        if(checkValid(temp)){
                            list.add(temp);
                        }
                        que2.add(temp);
                    }
                }
            }
            que = que2;
            que2 = new HashSet<String>();
        }
        
        return new ArrayList<String>(list);
    }
    
    private boolean checkValid(String s){
        int left = 0;
        int right = 0;
        for(int i = 0 ; i< s.length(); i++){
            if(s.charAt(i) == '('){
                left++;
            }else if(s.charAt(i)==')'){
                right++;
            }
            if(left < right){
                return false;
            }
        }
        return left == right;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveInvalidParentheses sln = new RemoveInvalidParentheses();
		List<String> ss= sln.removeInvalidParentheses(")()(e()))))))((((");
		
		for(int i = 0; i < ss.size(); i++){
			System.out.println(ss.get(i));
		}
	}

}
