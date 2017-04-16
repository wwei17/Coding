package LeetCode;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode output = null;
        int carry = 0; int sum = 0;
        
        ListNode curr = null, prev = null;
        while(l1 != null && l2 != null){
            curr = new ListNode(0);
            sum = l1.val + l2.val + carry;
            if(sum >= 10){
                carry = 1;
                sum -= 10;
            }else{
                carry = 0;
            }
            
            if(curr == null) curr = new ListNode(0);
            curr.val = sum;
            l1 = l1.next;
            l2 = l2.next;
            
            if(output == null) output = curr;
            else prev.next = curr;
            prev = curr;
        }
        
        while(l1 != null){
            curr = new ListNode(0);
            sum = l1.val + carry;
            if(sum >= 10){
                carry = 1;
                sum -= 10;
            }else{
                carry = 0;
            }
            
            if(curr == null) curr = new ListNode(0);
            curr.val = sum;
            l1 = l1.next;
            
            if(output == null) output = curr;
            else prev.next = curr;
            prev = curr;
        }
        
        while(l2 != null){
            curr = new ListNode(0);
            sum = l2.val + carry;
            if(sum >= 10){
                carry = 1;
                sum -= 10;
            }else{
                carry = 0;
            }
            
            if(curr == null) curr = new ListNode(0);
            curr.val = sum;
            l2 = l2.next;
            
            if(output == null) output = curr;
            else prev.next = curr;
            prev = curr;
        }
        if(carry == 1){
            curr = new ListNode(0);
            prev.next = curr;
            curr.val = 1;
        }
        return output;
        
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