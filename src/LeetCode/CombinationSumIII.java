package LeetCode;

import java.util.*;

public class CombinationSumIII {

    public List<List<Integer>> combinationSum3(int k, int n) {
        return combinationSum3(k, n, 1);
    }
    
    
    public List<List<Integer>> combinationSum3(int k, int n, int index) {
        List<List<Integer>> ll = new ArrayList<List<Integer>>();
        if(n < 0){
            
        }else if(n == 0){
            if(k == 0){
                ll.add(new ArrayList<Integer>());
            }
        }else{
            List<List<Integer>> temp = null;
            for(int i = index; i < 10; i++){
                temp = combinationSum3(k-1, n-i, i+1);
                for(int j = 0; j < temp.size(); j++){
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(i);
                    list.addAll(temp.get(j));
                    ll.add(list);
                }
            }
        }
        return ll;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
