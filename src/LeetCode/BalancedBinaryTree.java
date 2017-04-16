package LeetCode;

public class BalancedBinaryTree {

	public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }else{
            return isBallancedRec(root) >= 0;
        }
    }
    
    public int isBallancedRec(TreeNode r){
        int h1 = 0, h2 = 0;
        if(r == null){
            return 0;
        }else{
            h1 = isBallancedRec(r.left);
            if(h1 == -1) return -1;
            h2 = isBallancedRec(r.right);
            if(h2 == -1) return -1;
            
            if(Math.abs(h1 - h2) > 1){ 
                return -1;
            }else{
                return Math.max(h1, h2)+1;
            }
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
