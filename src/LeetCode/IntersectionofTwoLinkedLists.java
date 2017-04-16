package LeetCode;

public class IntersectionofTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;
        int countA = 0;
        int countB = 0;
        
        while(pA != null){
            countA++;
            pA = pA.next;
        }
        
        while(pB != null){
            countB++;
            pB = pB.next;
        }
        
        
        if(countA > countB){
            pA = headA;
            pB = headB;
        }else{
            int temp = countA;
            countA = countB;
            countB = temp;
            pA = headB;
            pB = headA;
        }
        for(int i = 0; i<countA-countB; i++){
            pA = pA.next;
        }
        while(pA != pB){
            pA = pA.next;
            pB = pB.next;
        }
        return pA;
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
