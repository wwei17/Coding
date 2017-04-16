package LeetCode;
import java.util.HashMap;

public class Solution {
	public static void main(String[] args){
		Solution sln = new Solution();
		int [] A = {1,2,3,4,5,8,9};
		System.out.println(sln.findClosestNum(A, 6));
	}
	
	
	
    public static int findClosestNum(int[] A, int m){
    	int start = 0;
    	int end = A.length -1;
    	int mid;
    	int result = Integer.MAX_VALUE;
    	
		if(A[start] > m) return A[start];
		else if(A[end] < m) return A[end];
		
    	while(end - start > 1){
    		mid = (start + end) /2;
    		if(A[mid] - m == 0) return mid;
    		if(A[mid] > m){	
    			end = mid;
    		}else{
    			start = mid;
    		}
    	}
    	
    	return Math.abs(A[start] - m) - Math.abs(A[end] - m) > 0? A[end] : A[start];
    }

}