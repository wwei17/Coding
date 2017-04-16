package LeetCode;

public class LowestCommonAncestorofaBinarySearchTree {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if((root.val <= p.val && root.val >= q.val) || (root.val >= p.val && root.val <= q.val)){
            return root;
        }else if(root.val < q.val && root.val < q.val){
            return lowestCommonAncestor(root.right, p, q);
        }else{
            return lowestCommonAncestor(root.left, p, q);
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
