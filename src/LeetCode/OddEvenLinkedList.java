package LeetCode;

public class OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {
        ListNode head_odd = head;
        ListNode head_even = null;
        if(head == null || head.next == null){
            return head;
        }else{
            head_even = head.next;
        }
        ListNode odd = head_odd;
        ListNode even = head_even;
        ListNode curr = head_even.next;
        int i = 3;
        while(curr != null){
            if((i&1) == 1){
                odd.next = curr;
                odd = curr;
            }else{
                even.next = curr;
                even = curr;
            }
            i++;
            curr = curr.next;
        }
        odd.next = head_even;
        even.next = null;
        return head;
    }
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OddEvenLinkedList sln = new OddEvenLinkedList();
		ListNode head = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		head.next = n2;
		n2.next = n3;
		head = sln.oddEvenList(head);
		while(head!=null){
			System.out.print(head.val+" ");
			head = head.next;
		}
		
	}

}
