package LeetCode;

public class PathSum {

    public boolean hasPathSum(TreeNode r, int sum) {
        if(r == null){
            return false;
        }
        
        int s = sum - r.val;
        if(r.left == null && r.right == null){
            if(s == 0){
                return true;
            }else{
                return false;
            }
        }else{
            if(r.left != null){
                if(hasPathSum(r.left, s)){
                    return true;
                }
            }
            if(r.right != null){
                if(hasPathSum(r.right, s)){
                    return true;
                }
            }
            return false;

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
