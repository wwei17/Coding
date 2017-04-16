package LeetCode;

import java.util.LinkedList;

public class ImplementStackusingQueues { //in leetcode, the class name should be MyStack

    LinkedList<Integer> list1 = new LinkedList<Integer>();
    LinkedList<Integer> list2 = new LinkedList<Integer>();
    int top;
    
    public void push(int x) {
        list1.offer(x);
        top = x;
    }

    // Removes the element on top of the stack.
    public void pop() {
        int size = list1.size();
        for(int i = 0; i < size-1; i++){
            top = list1.pollFirst();
            list2.offer(top);
            
        }
        list1 = list2;
        list2 = new LinkedList<Integer>();
    }

    // Get the top element.
    public int top() {
        return top;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return list1.size() == 0;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
