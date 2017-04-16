package LeetCode;

public class RotateList {

    public ListNode rotateRight(ListNode head, int n) {
        ListNode p1 = head;
        ListNode p2 = head;
        
        for(int i = 0 ; i < n; i++){
            if(p2 != null){
                p2 = p2.next != null? p2.next: head;
            }else {
                return head;
            }
        }
        
        while(p2 != null){
            if(p2.next == null){
                p2.next = head;
                head = p1.next;
                p1.next = null;
                
                break;
            }else{
                p2 = p2.next;
                p1 = p1.next;
            }
        }
        return head;
    }

    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RotateList s = new RotateList();
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(2);
		a1.next = a2;
		a2.next = null;
		
		ListNode head = s.rotateRight(a1, 1);
		
		while(head != null){
			System.out.print(head.val+ " ");
			head = head.next;
		}
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
