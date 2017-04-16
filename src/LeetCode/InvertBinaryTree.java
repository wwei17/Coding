package LeetCode;
import java.util.Stack;


public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        Stack<TreeNode> st = new Stack<TreeNode>();
        if(root == null) return null;
         TreeNode temp_p = null;
         TreeNode temp = null;
         st.push(root);
         
         while(st.size() != 0){
             temp_p = st.pop();
             if(temp_p != null){
                 temp = temp_p.left;
                 temp_p.left = temp_p.right;
                 temp_p.right = temp;
                 st.push(temp_p.left);
                 st.push(temp_p.right);
             }
             
         }
         return root;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	 public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
}
