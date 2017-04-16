package LeetCode;

import java.util.HashMap;

public class KthSmallestElementinaBST {

    public int kthSmallest(TreeNode root, int k) {
        HashMap<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
        buildMap(root, map);
        return findKth(root, map, k);
    }
    
    public int buildMap(TreeNode root, HashMap<TreeNode, Integer> map){
        if(root == null) return 0;
        int left_count = buildMap(root.left, map);
        int right_count = buildMap(root.right, map);
        int c = left_count+right_count+1;
        map.put(root, c);
        return c;
    }
    
    public int findKth(TreeNode root, HashMap<TreeNode, Integer> map, int k){
        int l = root.left!=null? map.get(root.left): 0;
        if(k<=l){
            return findKth(root.left, map, k);
        }else if(k == l+1){
            return root.val;
        }else{
            return findKth(root.right, map, k-l-1);
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
