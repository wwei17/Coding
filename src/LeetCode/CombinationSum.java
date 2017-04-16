package LeetCode;

import java.util.*;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        //remove dup
        return combinationSum(candidates, target, 0);
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target, int index){
        List<List<Integer>> temp = null;
        List<List<Integer>> res= new ArrayList<List<Integer>>();
        if(target == 0){
            res.add(new ArrayList<Integer>());
        }
        for(int i = index; i < candidates.length; i++){
            if(target-candidates[i] >= 0){
                temp = combinationSum(candidates, target-candidates[i], i);
                for(int j = 0; j < temp.size(); j++){
                    List<Integer> l2 = new ArrayList<Integer>();
                    l2.add(candidates[i]);
                    l2.addAll(temp.get(j));
                    res.add(l2);
                }
            }
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
