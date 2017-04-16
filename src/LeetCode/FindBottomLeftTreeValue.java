package LeetCode;

import java.util.HashMap;

public class FindBottomLeftTreeValue {

    public int findBottomLeftValue(TreeNode root) {
        HashMap<TreeNode, Integer> map = new  HashMap<TreeNode, Integer>();
        map.put(null, -1);
        return findBottomLeftValue(root, map, 1).val;
   }
   
   public TreeNode findBottomLeftValue(TreeNode root, HashMap<TreeNode, Integer> map, int level) {
       if(root.left == null && root.right == null){
           map.put(root, level);
           return root;
       }else{
           TreeNode left = null, right = null;
           if(root.left != null){
               left = findBottomLeftValue(root.left, map, level+1);
           }
           if(root.right != null){
               right = findBottomLeftValue(root.right, map, level+1);
           }
           return map.get(left) >= map.get(right)? left: right;
       }
       
       
       
   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
