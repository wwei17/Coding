package LeetCode;

import java.util.*;

public class BinaryTreeLevelOrderTraversalII {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Stack<TreeNode> st_n = new Stack<TreeNode>();
        Stack<Integer> st_l = new Stack<Integer>();
        
        if(root != null){
            st_n.push(root);
            st_l.push(0);
        }
        
        List<List<Integer>> ll = new ArrayList<List<Integer>>();
        
        TreeNode temp;
        int temp_l;
        while(st_n.size() > 0){
            temp = st_n.pop();
            temp_l = st_l.pop();
            
            if(temp_l == ll.size()){
                ll.add(0,new ArrayList<Integer>());
            }
            
            ll.get(ll.size()-temp_l-1).add(temp.val);
            
            if(temp.right != null){
                st_n.push(temp.right);
                st_l.push(temp_l+1);
            }
            if(temp.left != null){
                st_n.push(temp.left);
                st_l.push(temp_l+1);
            }
        }
        return ll;
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
