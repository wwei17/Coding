package LeetCode;
import java.util.*;


public class MinimumAbsoluteDifferenceinBST {

    public int getMinimumDifference(TreeNode root) {
        Stack<TreeNode> st1 = new Stack<TreeNode>();
        TreeNode curr = root;
        st1.push(root);
        ArrayList<Integer> list = new ArrayList<Integer>();
        do{
            while(curr != null && curr.left != null){
                curr = curr.left;
                st1.push(curr);
            }
            curr = st1.pop();
            list.add(curr.val);
            curr = curr.right;
            if(curr != null){
                st1.push(curr);
            }
        }while(st1.size()>0);
        
        int min = Integer.MAX_VALUE;
        for(int i = 1; i < list.size(); i++){
            min = Math.min(min, list.get(i)-list.get(i-1));
        }
        return min;
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
