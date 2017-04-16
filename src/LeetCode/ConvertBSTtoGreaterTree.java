package LeetCode;

import java.util.ArrayList;

public class ConvertBSTtoGreaterTree {

    public TreeNode convertBST(TreeNode root) {
        if(root == null) return null;
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        helper(root, list);
        for(int i = list.size()-2; i >=0; i--){
            list.get(i).val += list.get(i+1).val;
        }
        return root;
    }
    
    public void helper(TreeNode root , ArrayList<TreeNode> list){
        if(root.left != null){
            helper(root.left, list);    
        }
        list.add(root);
        if(root.right != null){
            helper(root.right, list);
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
