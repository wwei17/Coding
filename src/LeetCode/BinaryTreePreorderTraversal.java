package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> left;
        List<Integer> right;
        
        List<Integer> l = new ArrayList<Integer>();
        
        if(root== null){
            return l;
        }
        l.add(root.val);
        left = preorderTraversal(root.left);
        right = preorderTraversal(root.right);
        
        l.addAll(left);
        l.addAll(right);
            
        return l;
        
    }
    
    
    class TreeNode {
    	      int val;
    	      TreeNode left;
    	      TreeNode right;
    	      TreeNode(int x) { val = x; }
    	  }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
