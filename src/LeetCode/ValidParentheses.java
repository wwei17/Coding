package LeetCode;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack st = new Stack();
        char temp;
        for(int i = 0; i < s.length(); i ++){
            temp = s.charAt(i);
            if(temp == '(' || temp == '[' || temp == '{'){
                st.push(temp);
            }else if(st.size() > 0){
                if(temp == ')' && (char)st.peek() == '('){
                    st.pop();
                }else if(temp == ']' && (char)st.peek() == '['){
                    st.pop();
                }else if(temp == '}' && (char)st.peek() == '{'){
                    st.pop();
                }else{
                    return false;
                }
                
            }else{
                return false;
            }
        }
        if(st.size() == 0) return true;
        else return false;
    }
}
