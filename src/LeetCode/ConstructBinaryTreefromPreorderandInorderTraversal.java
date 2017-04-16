package LeetCode;

import java.util.HashMap;

public class ConstructBinaryTreefromPreorderandInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        if(preorder.length > 0){
            return buildTreeRec(preorder,0,preorder.length-1, inorder,0,inorder.length-1, map);
        }else{
            return null;
        }
    }
    
    public TreeNode buildTreeRec(int[] preorder,int pStart, int pEnd, int[] inorder, int iStart, int iEnd, HashMap<Integer, Integer> map){
        TreeNode root = new TreeNode(preorder[pStart]);
        if(pEnd - pStart > 0){
            int k = map.get(preorder[pStart]);
            int c = k - iStart;
            if(pStart+1 <= pStart+c)
                root.left = buildTreeRec(preorder, pStart+1, pStart+c, inorder, k-c, k-1, map);
            if(pStart+1+c <= pEnd)
                root.right = buildTreeRec(preorder, pStart+1+c, pEnd, inorder, k+1, iEnd, map);
        }
        
        return root;
    }
    
    public class TreeNode {
    	int val;
    	TreeNode left;
  		TreeNode right;
  		TreeNode(int x) { val = x; }
    }
}
