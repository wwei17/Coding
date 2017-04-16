package LeetCode;

import LeetCode.InsertionSortList.ListNode;

public class RemoveDuplicatesfromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        
        ListNode p1 = null, p2 = null;
        p1 = head; p2 = head;
        while(p2 != null){
            if(p1.val == p2.val){
                p2 = p2.next;
            }else{
                p1.next = p2;
                p1 = p2;
            }
        }
        if(p1 != null)
            p1.next = p2;
        return head;
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
