package LeetCode;

public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        ListNode p1 = null;
        ListNode p2 = head;
        
        while(p2 != null && p2 != p1 ){
            if(p1 == null) p1 = head;
            p1 = p1.next;
            p2 = p2.next;
            if(p2 != null) p2 = p2.next;
        }
        
        if(p2 == null) return false;
        else return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	  class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) {
		          val = x;
		          next = null;
		      }
		  }
}
