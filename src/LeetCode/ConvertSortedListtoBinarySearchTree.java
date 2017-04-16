package LeetCode;

import java.util.ArrayList;

public class ConvertSortedListtoBinarySearchTree {

    public TreeNode sortedListToBST(ListNode head) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        while(head != null){
            list.add(head.val);
            head = head.next;
        }
        if(list.size()>0)
            return balancedTree(list, 0, list.size()-1);
        else
            return null;
    }
    public TreeNode balancedTree(ArrayList<Integer> list, int start, int end){
        TreeNode root;
        if(end == start){
            root = new TreeNode(list.get(end));
        }else if(end - start == 1){
            TreeNode left = new TreeNode(list.get(start));
            root = new TreeNode(list.get(end));
            root.left = left;
        }else if(end - start == 2){
            TreeNode left = new TreeNode(list.get(start));
            TreeNode right = new TreeNode(list.get(end));
            root = new TreeNode(list.get((start+end)/2));
            root.left = left;
            root.right = right;
        }else{
            int mid = (start+end)/2;
            root = new TreeNode(list.get(mid));
            root.left = balancedTree(list, start, mid-1);
            root.right = balancedTree(list, mid+1, end);
        }
        return root;
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
	
	public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; next = null; }
		  }

}
