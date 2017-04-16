package LeetCode;

import java.util.Stack;

public class FlattenBinaryTreetoLinkedList {

    public void flatten(TreeNode root) {
        TreeNode curr;
        TreeNode prev = null;
        Stack<TreeNode> st = new Stack<TreeNode>();
        
        if(root != null) st.push(root);
        while(st.size()!=0){
            curr = st.pop();
            if(curr.right != null) st.push(curr.right);
            if(curr.left != null) st.push(curr.left);
            if(prev != null) {
                prev.right = curr;
                prev.left = null;
            }
            prev = curr;
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
}
