package LeetCode;

import java.util.ArrayList;

public class SumRoottoLeafNumbers {

    ArrayList<Integer> sums;
    public int sumNumbers(TreeNode root) {
        sums = new ArrayList<Integer>();
        sumNumbers(root, 0);
        int sum =0;
        for(int i = 0 ; i < sums.size();i++){
            sum += sums.get(i);
        }
        return sum;
    }
    
    public void sumNumbers(TreeNode root, int partialSum){
        if(root == null) return;
        else if(root.left == null && root.right == null){
            sums.add(partialSum*10 + root.val);
        }else{
            if(root.left != null){
                sumNumbers(root.left, partialSum*10 + root.val);
            }
            if(root.right != null){
                sumNumbers(root.right, partialSum*10 + root.val);
            }
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
}
