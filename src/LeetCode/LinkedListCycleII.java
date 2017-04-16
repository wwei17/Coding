package LeetCode;

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        ListNode p1 = null;
        ListNode p2 = head;
        
        while(p2 != null && p2!=p1){
            if(p1 == null) p1 = head;
            p1 = p1.next;
            p2 = p2.next;
            if(p2 != null) p2 = p2.next;
        }
        
        if(p2 == null) return null;
        else{
            p2 = head;
            while(p2!=p1){
                p1 = p1.next;
                p2 = p2.next;
            }
            return p2;
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
}
