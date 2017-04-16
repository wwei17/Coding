package LeetCode;

public class DiameterofBinaryTree {

    private int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        getHeight(root);
        return max;
    }
    
    public int getHeight(TreeNode root){
        if(root == null){
            return 0;    
        }else{
            int l = getHeight(root.left);
            int r = getHeight(root.right);
            max = Math.max(max, l+r);
            return Math.max(l, r)+1;
        }    
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
