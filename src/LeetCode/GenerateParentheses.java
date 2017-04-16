package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        Tuple t = new Tuple(0,0,n);
        generateParenthesis(t);
        return t.list;
    }
    
    public void generateParenthesis(Tuple t){
        if(t.right == t.n){
            t.list.add(t.sb.toString());
        }else{
            if(t.left < t.n){
                t.left ++;
                t.sb.append('(');
                generateParenthesis(t);
                t.left--;
                t.sb.setLength(t.sb.length() - 1);
            }
            if(t.left > t.right){
                t.right ++;
                t.sb.append(')');
                generateParenthesis(t);
                t.right--;
                t.sb.setLength(t.sb.length() - 1);
            }
        }
    }
    
    class Tuple{
        List<String> list;
        StringBuilder sb;
        int left;
        int right;
        int n;
        Tuple(int l, int r, int n){
            list = new ArrayList<String>();
            this.sb = new StringBuilder();
            this.left = l;
            this.right = r;
            this.n = n;
        }
    }
}
