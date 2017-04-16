package LeetCode;

import java.util.*;

public class FindLargestValueinEachTreeRow {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        LargestValues(root, list, 1);
        return list;
    }
    
    public void LargestValues(TreeNode root, List<Integer> list, int level){
        if(root != null){
            if(level > list.size()){
                list.add(root.val);
            }else{
                list.set(level-1, Math.max(root.val, list.get(level-1)));
            }
            LargestValues(root.left, list, level+1);
            LargestValues(root.right, list, level+1);
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
