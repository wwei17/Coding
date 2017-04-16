package LeetCode;

import java.util.HashMap;

public class CopyListwithRandomPointer {

    public RandomListNode copyRandomList(RandomListNode head) {
        HashMap<RandomListNode,RandomListNode> map = new HashMap<RandomListNode,RandomListNode>();
        RandomListNode temp = head, temp2= null;
        RandomListNode prev = null;
        RandomListNode newHead = null;
        while(temp != null){
            RandomListNode node = new RandomListNode(temp.label);
            if(prev != null) prev.next = node;
            else newHead = node;
            prev = node;
            map.put(temp, node);
            temp = temp.next;
        }
        temp = head;
        temp2 = newHead;
        while(temp != null){
            if(temp.random != null){
                temp2.random = map.get(temp.random);
            }else{
                temp2.random = null;
            }
            temp = temp.next;
            temp2 = temp2.next;
        }
        return newHead;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 class RandomListNode {
		      int label;
		      RandomListNode next, random;
		      RandomListNode(int x) { this.label = x; }
		  };
}
