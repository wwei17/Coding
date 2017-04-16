package LeetCode;

import java.util.Stack;

public class MinStack {

    Stack s;
    Stack mins;
    
    public MinStack(){
        s = new Stack();
        mins = new Stack();
    }
    
    public void push(int x) {
        s.push(x);
        if(mins.size() == 0 || x <= (int)mins.peek()){
            mins.push(x);
        }
    }

    public void pop() {
        int min = (int)s.pop();
        if(min == (int)mins.peek()){
            mins.pop();
        }
    }

    public int top() {
        return (int)s.peek();
    }

    public int getMin() {
        return (int)mins.peek();
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
