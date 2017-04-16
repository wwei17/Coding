package LeetCode;

import java.util.*;

public class FindKPairswithSmallestSums {

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> list = new ArrayList<int[]>();
        if(nums1.length == 0 || nums2.length==0) return list;
        PriorityQueue<Cell> pq = new PriorityQueue<Cell>();
        for(int i = 0 ; i < nums1.length; i++){
            pq.offer(new Cell(nums1[i], nums2[0], i, 0));
        }
        
        Cell curr= null;
        while(k > 0 && pq.size()> 0){
            curr = pq.poll();
            list.add(new int[]{curr.x, curr.y});
            if(curr.y_i+1 < nums2.length){
                pq.offer(new Cell(nums1[curr.x_i], nums2[curr.y_i+1], curr.x_i, curr.y_i+1));
            }
            k--;
        }
        return list;
        
    }
    
    class Cell implements Comparable<Cell>{
        int x; int y;
        int x_i; int y_i;
        Cell(int x1, int y1, int x1_i, int y1_i){
            this.x = x1;
            this.y = y1;
            this.x_i = x1_i;
            this.y_i = y1_i;
        }
        
        @Override
        public int compareTo(Cell c){
            return this.x+this.y-c.x-c.y;
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
