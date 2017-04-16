package LeetCode;

import java.util.Random;

public class LinkedListRandomNode {

    ListNode head;
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public LinkedListRandomNode(ListNode head) {
        this.head = head;
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        Random r = new Random();
        int res = head.val;
        int len= 2;
        ListNode next = head.next;
        while(next!=null){
            if(r.nextInt(len) == 0){
                res = next.val;
            }
            len++;
            next = next.next;
        }
        return res;
    }
	class ListNode {
		     int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
