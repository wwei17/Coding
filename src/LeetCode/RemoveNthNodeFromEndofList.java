package LeetCode;

public class RemoveNthNodeFromEndofList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prev = null, p1 = head, p2 = null;
        int i = 0;
        while(i < n){
            p1 = p1.next;
            i++;
        }
        
        p2 = head;
        while(p1 != null){
            if(prev == null){
                prev = head;
            }else{
                prev = prev.next;
            }
            
            p1 = p1.next;
            p2 = p2.next;
        }
        
        if(prev == null) return head.next;
        else{
            prev.next = p2.next;
            return head;
        }
        
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
