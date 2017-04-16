package LeetCode;
import java.util.*;


public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        Stack<Integer> st_l = new Stack<Integer>();
        Stack<TreeNode> st_n = new Stack<TreeNode>();
        
        List<List<Integer>> ll = new ArrayList<List<Integer>>();
        
        TreeNode temp = root;
        int temp_l = 0;
        if(temp != null){
            st_n.push(temp);
            st_l.push(temp_l);
        }
        
        while(st_n.size()>0){
            temp = st_n.pop();
            temp_l = st_l.pop();
            
            if(temp_l == ll.size()){
                ll.add(new ArrayList<Integer>());
            }
            
            ll.get(temp_l).add(temp.val);
            
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
	class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
}
