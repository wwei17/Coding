package LeetCode;

public class SameTree {

	 public boolean isSameTree(TreeNode p, TreeNode q) {
	        boolean nd = false, lf = false, rt=false;
	        
	        if(p != null && q != null){
	            nd = (p.val == q.val);
	            if(p.left != null && q.left != null){
	                lf = isSameTree(p.left, q.left);
	            }else if(p.left == null && q.left == null){
	                lf = true;
	            }else{
	                lf = false;
	            }
	            if(p.right != null && q.right != null){
	                rt = isSameTree(p.right, q.right);
	            }else if(p.right == null && q.right == null){
	                rt = true;
	            }else{
	                rt = false;
	            }  
	            return nd && lf && rt;
	            
	        }else if(p == null && q == null){
	            return true;
	        }else{
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
