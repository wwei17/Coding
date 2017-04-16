package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> l = new ArrayList<Integer>();
        boolean noRight = false;
        Stack s = new Stack();
        if(root == null) return l;
        else s.push(root);
        TreeNode temp;
        while(!s.empty()){
            if(!noRight){
                temp = (TreeNode)s.peek();
                while(temp.left != null){
                    s.push(temp.left);
                    temp = temp.left;
                }
            }
            
            temp = (TreeNode)s.pop();
            l.add(temp.val);
            if(temp.right != null){
                s.push(temp.right);
                noRight = false;
            }else{
                noRight = true;
            }
         
        }
        return l;
        
        
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
