package LeetCode;

import java.util.*;

public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        //remove dup
        return combinationSum2(candidates, target, 0);
    }
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target, int index){
        List<List<Integer>> temp = null;
        List<List<Integer>> res= new ArrayList<List<Integer>>();
        if(target == 0){
            res.add(new ArrayList<Integer>());
        }
        for(int i = index; i < candidates.length; i++){
            if(i > index && candidates[i] == candidates[i-1]){
                continue;
            }
            if(target-candidates[i] >= 0){
                temp = combinationSum2(candidates, target-candidates[i], i+1);
                for(int j = 0; j < temp.size(); j++){
                    List<Integer> l2 = new ArrayList<Integer>();
                    l2.add(candidates[i]);
                    l2.addAll(temp.get(j));
                    res.add(l2);
                }
                if(i > 0 && candidates[i] == candidates[i-1]){
                    
                }
            }
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
