package LeetCode;

import java.util.*;

public class BoundaryofBinaryTree {

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if(root == null) return new ArrayList<Integer>();
        ArrayList<TreeNode> leftList = findLeft(root.left);
        ArrayList<TreeNode> leavesList = new ArrayList<TreeNode>();   
        dfs(root, leavesList);
        ArrayList<TreeNode> rightList = findRight(root.right);
        List<TreeNode> list = new ArrayList<TreeNode>();
        list.add(root);
        for(int i = 0 ; i < leftList.size(); i++){
            list.add(leftList.get(i));
        }
        for(int i = 0 ; i < leavesList.size(); i++){
            if(list.get(list.size()-1) != leavesList.get(i)) list.add(leavesList.get(i));
        }
        for(int i = rightList.size()-1 ; i >= 0 ; i--){
            if(list.get(list.size()-1) != rightList.get(i)) list.add(rightList.get(i));
        }
        List<Integer> res = new ArrayList<Integer>();
        for(int i = 0 ; i < list.size(); i++){
            res.add(list.get(i).val);
        }
        return res;
    }
    
    public void dfs(TreeNode root, ArrayList<TreeNode> leavesList){
        if(root != null){
            if(root.left == null && root.right == null){
                leavesList.add(root);
            }else{
                if(root.left != null){
                    dfs(root.left, leavesList);
                }
                
                if(root.right != null){
                    dfs(root.right, leavesList);
                }
            }
        }
    }
    
    public ArrayList<TreeNode> findLeft(TreeNode root){
        
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        if(root == null) return list;
        TreeNode curr = root;
        list.add(root);
        while(curr.left != null || curr.right != null){
            if(curr.left != null){
                list.add(curr.left);
                curr = curr.left;
            }else{
                list.add(curr.right);
                curr = curr.right;
            }
        }
        return list;
    }
    
    public ArrayList<TreeNode> findRight(TreeNode root){
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        if(root == null) return list;
        TreeNode curr = root;
        list.add(root);
        while(curr.left != null || curr.right != null){
            if(curr.right != null){
                list.add(curr.right);
                curr = curr.right;
            }else{
                list.add(curr.left);
                curr = curr.left;
            }
        }
        return list;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
