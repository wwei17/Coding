package LeetCode;

public class MinimumDepthofBinaryTree {

    public int minDepth(TreeNode root) {
        int l =Integer.MAX_VALUE,r=Integer.MAX_VALUE;
        if(root == null){
            return 0;
        }else{
            if(root.left == null && root.right == null){
                return 1;
            }
            if(root.left != null){
                l = minDepth(root.left);
            }
            if(root.right != null){
                r = minDepth(root.right);
            }
            return Math.min(l,r)+1;
        }
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
