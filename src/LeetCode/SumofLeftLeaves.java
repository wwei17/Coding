package LeetCode;

import java.util.*;

public class SumofLeftLeaves {

	public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        Stack<TreeNode> st = new Stack<TreeNode>();
        HashSet<TreeNode> set = new HashSet<TreeNode>();
        if(root != null) st.push(root);
        TreeNode curr = null;
        while(st.size()>0){
            curr = st.pop();
            if(curr.left != null){
                set.add(curr.left);
                st.push(curr.left);
            }else if(curr.right == null && set.contains(curr)){
                sum += curr.val;
            }
                
            if(curr.right != null){
                st.push(curr.right);
            }
        }
        return sum;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
