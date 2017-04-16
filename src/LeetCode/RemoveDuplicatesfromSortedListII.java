package LeetCode;

public class RemoveDuplicatesfromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode p1, p2, p3;
        p1 = head;
        p2 = null;
        p3 = null;
        while(p1 != null){
            if(p1 == head || p1.val != p2.val){
                if(p2 != null && p2.next != p1){
                    p2.val = p1.val;
                    p2.next = p1.next;
                }else{
                    p3 = p2;
                    p2 = p1;
                }
            }else{
                
            }
            p1 = p1.next;
        }
        if(p2 != null && p2.next != p1){
            if(p3 == null){
                head = null;
            }else{
                p3.next = null;
            }
        }
        return head;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
