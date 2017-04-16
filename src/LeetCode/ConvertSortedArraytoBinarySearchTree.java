package LeetCode;

public class ConvertSortedArraytoBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] num) {
        if(num != null && num.length > 0)
            return sortedArrayToSubBST(num, 0, num.length-1);
        else
            return null;
    }
    
    public TreeNode sortedArrayToSubBST(int[] num, int start, int end){
        int m = (start+end)/2;
        TreeNode t = new TreeNode(num[m]);
        if(start <= m-1){
            t.left = sortedArrayToSubBST(num, start, m-1);
        }
        if(m+1 <= end){
            t.right = sortedArrayToSubBST(num, m+1 , end);
        }
        return t;
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
