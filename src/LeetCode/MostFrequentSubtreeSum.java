package LeetCode;

import java.util.*;

public class MostFrequentSubtreeSum {

    public int[] findFrequentTreeSum(TreeNode root) {
        FrequencyRecorder fr = new FrequencyRecorder();
        findTreeSum(root, fr);
        return fr.getMaxFQKey();
    }
    
    public int findTreeSum(TreeNode root, FrequencyRecorder fr){
        if(root == null){
            return 0;
        }else{
            int sum = findTreeSum(root.left, fr) + findTreeSum(root.right, fr) + root.val;
            fr.increment(sum);
            return sum;
        }
    }
    
    class FrequencyRecorder{
        private HashMap<Integer, Integer> map;
        private int mexFreq;
        FrequencyRecorder(){
            map = new HashMap<Integer, Integer>();
            mexFreq = 0;
        }
        
        void increment(int key){
            int f = map.getOrDefault(key, 0)+1;
            if(f>mexFreq) mexFreq = f;
            map.put(key, f);
        }
        
        int[] getMaxFQKey(){
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(Integer key: map.keySet()){
                if(map.get(key) == mexFreq){
                    list.add(key);
                }
            }
            int[] a = new int[list.size()];
            for(int i = 0 ; i < a.length; i++){
                a[i] = list.get(i);
            }
            return a;
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
