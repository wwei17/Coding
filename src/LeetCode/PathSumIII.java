package LeetCode;

import java.util.HashMap;

public class PathSumIII {

    public int pathSum(TreeNode root, int sum) {
        return pathSum(root, sum, new HashMap<Integer, Integer>());
    }
    
    public int pathSum(TreeNode root, int sum, HashMap<Integer, Integer> map) {
        if(root == null) return 0;
        HashMap<Integer, Integer> map2 = new HashMap<Integer, Integer>();
        map2.put(root.val, 1);
        int count = root.val == sum? 1: 0;
        for(int val: map.keySet()){
            if(map2.containsKey(val+root.val)){
                map2.put(val+root.val , map2.get(val+root.val)+map.get(val));
            }else{
                map2.put(val+root.val , map.get(val));
            }
            if(val+root.val == sum) count += map.get(val);
        }
        return pathSum(root.left, sum, map2) + pathSum(root.right, sum, map2) + count;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
