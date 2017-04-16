package LeetCode;

import java.util.*;

public class FindMedianfromDataStream {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	class MedianFinder {
	    
	    PriorityQueue<Integer> maxQ = new PriorityQueue<Integer>(20, Collections.reverseOrder());
	    PriorityQueue<Integer> minQ = new PriorityQueue<Integer>(); 
	    int mid = 0;
	    int size = 0;
	    
	    public void addNum(int num) {
	        if(size == 0){
	            mid = num;
	        }else{
	            if(size %2 == 0){
	                int left = maxQ.peek();
	                int right = minQ.peek();
	                if(num > left && num < right){
	                    mid = num;
	                }else if(num <= left){
	                    mid = maxQ.poll();
	                    maxQ.offer(num);
	                }else{
	                    mid = minQ.poll();
	                    minQ.offer(num);
	                }
	            }else{
	                if(num > mid){
	                    minQ.offer(num);
	                    maxQ.offer(mid);
	                }else{
	                    maxQ.offer(num);
	                    minQ.offer(mid);
	                }
	            }
	        }
	        size++;
	    }


	    // Returns the median of current data stream
	    public double findMedian() {
	        if(size%2 == 0){
	            return (0.0+maxQ.peek()+minQ.peek())/2;
	        }else{
	            return mid;
	        }
	    }
	    
	}
	

}
