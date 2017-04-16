package LeetCode;

public class HouseRobberIII {

    public int rob(TreeNode root) {
        int[] a = take_or_not(root);
        return a[0]>a[1]?a[0]:a[1];
    }
    
    public int[] take_or_not(TreeNode node){
        int[] a = new int[2];
        if(node == null){
            a[0] = 0;
            a[1] = 0;
        }else{
            int[] l = take_or_not(node.left);
            int[] r = take_or_not(node.right);
            a[0] = node.val + l[1]+r[1];
            a[1] = Math.max(Math.max(l[1]+r[1],l[1]+r[0]), Math.max(l[0]+r[1],l[0]+r[0]));
        }
        return a;
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
