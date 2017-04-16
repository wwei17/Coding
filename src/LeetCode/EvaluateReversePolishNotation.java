package LeetCode;

import java.util.Stack;

public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        int i = 0; Stack stk = new Stack();
        while(i <tokens.length){
            if(tokens[i].matches("-?\\d+")){
                stk.push(tokens[i]);
            }else{
                int op1 = Integer.parseInt((String)stk.pop());
                int op2 = Integer.parseInt((String)stk.pop());
                stk.push(compute(op2,op1,tokens[i])+"");
            }
            i++;
        }
        return Integer.parseInt((String)stk.pop());
 
    }
    
    public int compute(int a, int b, String op){
        if(op.equals("+")){
            return a+b;
        }else if(op.equals("-")){
            return a -b;
        }else if(op.equals("*")){
            return a*b;
        }else{
            return a/b;
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
