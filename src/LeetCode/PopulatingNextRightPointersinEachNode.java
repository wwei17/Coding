package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersinEachNode {

    public void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> s1 = new LinkedList<TreeLinkNode>();
        Queue<TreeLinkNode> s2 = new LinkedList<TreeLinkNode>();
        if(root == null) return;
        else s1.offer(root);
        Queue<TreeLinkNode> temp;
        TreeLinkNode t1 = null;
        while(!s1.isEmpty()){
            t1 = s1.poll();
            
            if(t1.left != null)
                s2.offer(t1.left);
            if(t1.right != null)
                s2.offer(t1.right);
            
            
            
            if(s1.isEmpty()){
                t1.next = null;
                temp = s1;
                s1 = s2;
                s2 = temp;
                
            }else{
                t1.next = s1.peek();
            }
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	class TreeLinkNode {
		     int val;
		      TreeLinkNode left, right, next;
		      TreeLinkNode(int x) { val = x; }
		  }
}
