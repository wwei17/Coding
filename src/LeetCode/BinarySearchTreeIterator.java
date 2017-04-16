package LeetCode;

import java.util.Stack;

public class BinarySearchTreeIterator {

    Stack<TreeNode> st;
    TreeNode curr;

    public BinarySearchTreeIterator(TreeNode root) {
        st = new Stack<TreeNode>();
        curr = root;
        
        while(curr != null){
            st.push(curr);
            curr = curr.left;
        }
        
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return st.size()!=0;
    }

    /** @return the next smallest number */
    public int next() {
        curr = st.pop();
        int result = curr.val;
        curr = curr.right;
        while(curr != null){
            st.push(curr);
            curr = curr.left;
        }
        return result;
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
