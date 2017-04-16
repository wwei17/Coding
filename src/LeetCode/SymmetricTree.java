package LeetCode;

import java.util.Stack;

public class SymmetricTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public boolean isSymmetric(TreeNode root) {
        /*if(root != null){
            return isSymmetricRec(root.left, root.right);
        }else{
            return true;
        }*/
        return isSymmetricNonRec(root);
    }
    
    public boolean isSymmetricRec(TreeNode r1, TreeNode r2){
        boolean nd=false, lt=false, rt=false;
        
        if(r1 == null && r2 == null){
            return true;
            
        }else if(r1 != null && r2 != null){
            nd = (r1.val == r2.val);
            if(!nd) return false;
            
            if(r1.left !=null && r2.right !=null){
                lt = isSymmetricRec(r1.left,r2.right);
            }else if(r1.left == null && r2.right == null){
                lt = true;
            }else{
                lt = false;   
            }
            if(!lt) return false;

            if(r1.right !=null && r2.left !=null){
                rt = isSymmetricRec(r1.right,r2.left);
            }else if(r1.right == null && r2.left == null){
                rt = true;
            }else{
                rt = false;   
            }
            
            return nd&&lt&&rt;
        }else{
            return false;
        }
    }
    
    public boolean isSymmetricNonRec(TreeNode root){
        Stack sk1 = new Stack();
        Stack sk2 = new Stack();
        
        if(root == null) return true;
        if(root.left != null)
            sk1.push(root.left);
        if(root.right != null)
            sk2.push(root.right);
        
        while(!sk1.empty() && !sk2.empty()){
            TreeNode l = (TreeNode)sk1.pop();
            TreeNode r = (TreeNode)sk2.pop();
            
            if(l.val != r.val){
                return false;
            }
            if(l.left != null && r.right != null){
                sk1.push(l.left);
                sk2.push(r.right);
            }else if(l.left == null && r.right==null){
                
            }else{
                return false;
            }
            
            if(l.right != null && r.left != null){
                sk1.push(l.right);
                sk2.push(r.left);
            }else if(l.right == null && r.left==null){
                
            }else{
                return false;
            }
            
        }
        if(sk1.empty() && sk2.empty()){
            return true;
        }else{
            return false;
        }
        
    }
    public class TreeNode {
    	      int val;
    	      TreeNode left;
    	      TreeNode right;
    	      TreeNode(int x) { val = x; }
    	  }
}
