package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
	
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> l = new ArrayList<List<Integer>>();
        
        
        if(root == null){
            return l;
        }else{
            int sum_r = sum - root.val;
            
            if(root.left == null && root.right == null){
                if(sum_r == 0){
                    List l_a = new ArrayList<Integer>();
                    l_a.add(0,root.val);
                    l.add(l_a);
                }
                return l;
                
            }else{
                List<List<Integer>> l_l;
                if(root.left != null){
                    l_l = pathSum(root.left, sum_r);
                    if(l_l.size() != 0){
                        for(int i = 0; i < l_l.size(); i++){
                            l_l.get(i).add(0,root.val);
                            l.add(l_l.get(i));
                        }
                    }
                }
                List<List<Integer>> l_r;
                if(root.right != null){
                    l_r = pathSum(root.right, sum_r);
                    if(l_r.size() != 0){
                          for(int i = 0; i < l_r.size(); i++){
                            l_r.get(i).add(0,root.val);
                            l.add(l_r.get(i));
                        }
                    }
                }
                return l;
                
            }
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
