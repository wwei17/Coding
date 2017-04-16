package LeetCode;

import java.util.Stack;

public class ImplementQueueusingStacks {

    // Push element x to the back of queue.
    Stack<Integer> st1 = new Stack<Integer>();
    Stack<Integer> st2 = new Stack<Integer>();
    public void push(int x) {
        st1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(st2.size() == 0){
            while(st1.size() > 0){
                st2.push(st1.pop());
            }
        }
        if(st2.size()>0) st2.pop();
    }

    // Get the front element.
    public int peek() {
        if(st2.size() == 0){
            while(st1.size() > 0){
                st2.push(st1.pop());
            }
        }
        return st2.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return st2.size()+st1.size()==0;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
