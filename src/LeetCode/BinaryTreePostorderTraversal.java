package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        
        
        List ans = new ArrayList<Integer>();
        Stack temp1 = new Stack();
        Stack temp2 = new Stack();
        TreeNode curr = root;
        if(root != null)
            temp1.push(curr);
        
        while(!temp1.empty()){
            curr = (TreeNode)(temp1.pop());
            temp2.push(curr);
            if(curr.left != null){
                temp1.push(curr.left);
            }
            if(curr.right != null){
                temp1.push(curr.right);
            }
            
        }
        while(!temp2.empty()){
            ans.add(((TreeNode)(temp2.pop())).val);
        }
        
        return ans;
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
