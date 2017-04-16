package LeetCode;

public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode temp = null;
        ListNode prev = null;
        while(p1 != null && p2 != null){
            if(p1.val < p2.val){
                temp = p1;
                p1 = p1.next;
            }else{
                temp = p2;
                p2 = p2.next;
            }
            if(head == null){
                head = temp;
            }else{
                prev.next = temp;
            }
            prev = temp;
        }
        while(p1 != null){
            temp = p1;
            p1 = p1.next;
            if(head == null){
                head = temp;
            }else{
                prev.next = temp;
            }
            prev = temp;
        }
        while(p2 != null){
            temp = p2;
            p2 = p2.next;
            if(head == null){
                head = temp;
            }else{
                prev.next = temp;
            }
            prev = temp;
        }
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
