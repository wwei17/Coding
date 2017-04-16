package LeetCode;

public class ReverseNodesinkGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k < 2) return head;
        ListNode nextK = null;
        ListNode subHead = null;
        ListNode subTail = null;
        ListNode next = null;
        ListNode curr = null;
        ListNode prev = null;
        int count = 0;
        nextK = head;
        do{
            for(int i = 0; i < k; i++){
                if(nextK == null) break;
                else nextK = nextK.next;
                count++;
            }
            subTail = next==null? head: next;
            if(count%k == 0){
                for(int i = k; i> 0 ;i--){
                    prev = curr;
                    curr = curr==null? head: next;
                    next = curr.next;
                    curr.next =prev;
                }
                if(count == k) head = curr;
                if(subHead != null) subHead.next = curr;
                subHead = curr = subTail;
                subTail.next = next;
            }
        }while(nextK != null);
        
        return head;

    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		ListNode curr = head;
		for(int i = 2; i <5 ;i++){
			ListNode temp = new ListNode(i);
			curr.next = temp;
			curr = temp;
			
		}
		ReverseNodesinkGroup sln = new ReverseNodesinkGroup();
		head = sln.reverseKGroup(head, 2);
		while(head != null){
			System.out.print(head.val+" ");
			head = head.next;
			
		}
	}

}
