package LeetCode;

public class PalindromeLinkedList {

	public class Solution {
	    public boolean isPalindrome(ListNode head) {
	        int size = 0; 
	        int res = 0;
	        ListNode curr = head;
	        while(curr != null){
	            curr = curr.next;
	            size++;
	        }
	        curr = head;
	        int i = 0;
	        int[] map = {241, 837, 432,344};
	        while(i < size/2){
	            res += curr.val^map[i%4];
	            curr = curr.next;
	            i++;
	        }
	        if(size%2 == 1) curr = curr.next;
	        while(i > 0){
	            i--;
	            res -= curr.val^map[i%4];
	            curr = curr.next;
	        }
	        return res == 0;
	    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
