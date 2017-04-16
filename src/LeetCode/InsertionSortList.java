package LeetCode;

public class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        ListNode curr = null, prev = null, head2 = null, node = null;
        while(head!= null){
            node = head;
            head = head.next;
            curr = head2;
            while(curr != null){
                if(curr.val > node.val){
                    break;
                }
                prev = curr;
                curr = curr.next;
            }
            
            if(head2 == null || head2 == curr){
                head2 = node;
                node.next = curr;
            }else{
                prev.next = node; 
                node.next = curr;
            }
        }
        return head2;
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
