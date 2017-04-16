package LeetCode;

import java.util.Stack;

public class ReorderList {

    public void reorderList(ListNode head) {
        ListNode l1=null, curr1 = head, prev1 = null;
        ListNode l2=null, curr2 = head, prev2 = null;
        while(curr2 != null){
            if(l1 == null){
                l1 = curr1;
            }else{
                prev1.next = curr1;
            
            }
            prev1 = curr1;    
            curr1 = curr1.next;
            curr2 = curr2.next;
            if(curr2 != null) curr2 = curr2.next;
        }
        l2 = curr1;
        if(prev1 != null) prev1.next = null;
        
        Stack temp = new Stack();
        curr2 = l2; prev2 = null;
        while(curr2 != null){
            temp.push(curr2);
            curr2 = curr2.next;
        }

        head = null;curr1=l1; curr2= null;
        ListNode curr;
        while(curr1 != null){
            
            if(head == null){
                head = curr1;
            }else{
                prev2.next = curr1;
            }
            if(!temp.empty()) {
                curr2 = (ListNode)temp.pop();
                curr2.next = null;
            }else{
                curr2 = null;
            }
            curr = curr1.next;
            curr1.next = curr2;
            prev2 = curr2;
            
            curr1 = curr;
        }
    }
    
     class ListNode {
    	      int val;
    	      ListNode next;
    	      ListNode(int x) {
    	          val = x;
    	          next = null;
    	      }
    	  }
     
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
