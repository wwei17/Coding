package LeetCode;
import java.util.*;


public class NonoverlappingIntervals {

    public int eraseOverlapIntervals(Interval[] intervals) {
        if(intervals.length == 0 ) return 0;
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
        });
        int[] counts = new int[intervals.length];
        int max = 0;
        for(int i = 0 ; i < intervals.length; i++){
            for(int j = i-1 ; j >= 0 ; j--){
                if(intervals[i].start >= intervals[j].end){
                    counts[i] = Math.max(counts[j]+1, counts[i]);
                }
            }
            max = Math.max(max, counts[i]);
        }
        return intervals.length-max-1;
    }
    
    class Interval {
    	      int start;
    	      int end;
    	      Interval() { start = 0; end = 0; }
    	      Interval(int s, int e) { start = s; end = e; }
    	  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
