package LeetCode;

public class SwapNodesinPairs {

    public ListNode swapPairs(ListNode head) {
        ListNode newHead = head;
        ListNode currOdd = null, currEven = null;
        ListNode prev = null;
        currOdd = head;
        if(head != null) currEven = head.next;
        while(currOdd != null && currEven != null){
            if(newHead == head){
                newHead = currEven;
            }else{
                prev.next = currEven;
            }
            
            currOdd.next = currEven.next;
            currEven.next = currOdd;
            
            prev = currOdd;
            currOdd = currOdd.next;
            if(currOdd != null) {
                currEven = currOdd.next;
            }else{
                currEven = null;
            }
            
        }
        
        return newHead;
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
