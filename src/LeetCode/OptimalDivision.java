package LeetCode;

import java.util.HashMap;

public class OptimalDivision {

	class Result{
		double res;
		String formula;
		int start;
		int end;
		
		Result(double r, String f, int s, int e){
			res = r;
			formula = f;
			start = s;
			end = e;
		}
	}
	
    public String optimalDivision(int[] nums) {
    	Result res = optimalDivision(nums, 0, nums.length-1, true,  new HashMap<Integer, Result>());
    	System.out.println(res.res);
        return res.formula;
    }
    
    public Result optimalDivision(int[] nums, int start, int end, boolean isMax, HashMap<Integer, Result> map) {
    	int key = (start << 10) | end;
    	if(map.containsKey(key)){
    		return map.get(key);
    	}
    	Result finalResult = null;
    	if(end - start == 1){
    		finalResult= new Result(nums[start]*1.0/nums[end], nums[start]+"/"+nums[end], start, end);
    	}else if(start == end){
    		finalResult= new Result(nums[start], nums[start]+"", start, end);
    	}else{
    		Result res_r1 = null;
    		Result res_r2 = null;
    		double res = isMax? 0: 999999999;
    		for(int i = start; i < end; i++){
    			Result r1 = optimalDivision(nums, start, i, isMax, map);
    			Result r2 = optimalDivision(nums, i+1, end, !isMax, map);
    			double r = r1.res/r2.res;
    			if((isMax && r > res) || (!isMax && r < res)){
    				res_r1 = r1;
    				res_r2 = r2;
    				res = r;
    			}
    		}
    		if(res_r2.start != res_r2.end) finalResult= new Result(res, res_r1.formula+"/("+res_r2.formula+")", start, end);
    		else finalResult= new Result(res, res_r1.formula+"/"+res_r2.formula, start, end);
    	}
    	map.put(key, finalResult);
    	return finalResult;

    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OptimalDivision sln = new OptimalDivision();
		int [] a = {6,2,3,4,5};
		
		System.out.println(sln.optimalDivision(a));
	}

}
