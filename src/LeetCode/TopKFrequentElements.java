package LeetCode;

import java.util.*;

public class TopKFrequentElements {

    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int val: nums){
            map.put(val, map.getOrDefault(val, 0)+1);
        }
        PriorityQueue<Cell> q = new PriorityQueue<Cell>();
        for(int key: map.keySet()){
            Cell c = new Cell(key, map.get(key));
            if(q.size() >= k && c.compareTo(q.peek())>0){
                q.poll();
                q.offer(c);
            }else if(q.size() < k){
            	q.offer(c);
            }
        }
        List<Integer> list = new ArrayList<Integer>();
        
        for(int i = 0 ; q.size()>0; i++){
            list.add(q.poll().val);
        }
        return list;
    }
    
    class Cell implements Comparable<Cell>{
        int val;
        int count;
        Cell(int v, int n){
            this.val = v;
            this.count = n;
        }
        
        @Override
        public int compareTo(Cell c){
            return this.count-c.count;
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TopKFrequentElements sln = new TopKFrequentElements();
		List<Integer> res = sln.topKFrequent(new int[]{1,1,1,2,2,3}, 2);
		for(int i = 0 ; i < res.size(); i++){
			System.out.print(res.get(i)+" ");
		}
	}

}
