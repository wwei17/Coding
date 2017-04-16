package LeetCode;

public class SortList {

    public ListNode sortList(ListNode head) {
        ListNode p1, p2, prev1;
        p1 = head; p2 = head;
        prev1 = null;
        if(head == null) return null;
        else if(head.next == null) return head;
        while(p2 != null){
            if(p1 != null){
                prev1 = p1;
            }
            p1 = p1.next;
            p2 = p2.next;
            if(p2 != null){
                p2 = p2.next;
            }
        }
        ListNode m2 = null;
        if(p1 != null){
            m2 = sortList(p1);
        }
        prev1.next = null;
        ListNode m1 = sortList(head);
        
        
        return mergeLinks(m1,m2);
    }
    
    public ListNode mergeLinks(ListNode n1, ListNode n2){
        ListNode head = null;
        ListNode curr=null, prev=null;
        while(n1 != null && n2 != null){
            if(n1.val < n2.val){
                curr = n1;
                if(head == null){
                    head = curr;
                }else{
                    prev.next = curr;
                }
                prev = curr;
                n1 = n1.next;     
            }else{
                curr = n2;
                if(head == null){
                    head = curr;
                }else{
                    prev.next = curr;
                }
                prev = curr;
                n2 = n2.next; 
            }
        }
        
        while(n1!=null){
            curr = n1;
            if(head == null){
                head = curr;
            }else{
                prev.next = curr;
            }
            prev = curr;
            n1 = n1.next;
        }
        
        while(n2 != null){
            curr = n2;
            if(head == null){
                head = curr;
            }else{
                prev.next = curr;
            }
            prev = curr;
            n2 = n2.next; 
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
