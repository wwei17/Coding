package LeetCode;

import java.util.*;

public class FindRightInterval {

    public int[] findRightInterval(Interval[] intervals) {
        int [] indice = new int[intervals.length];
        HashMap<Interval, Integer> map = new HashMap<Interval, Integer>();
        for(int i = 0 ; i< intervals.length; i++){
            map.put(intervals[i], i);
        }
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval it1, Interval it2){
                return it1.start-it2.start;
            }
        });
        int index = -1;
        for(int i = 0 ;i < intervals.length; i++){
            index = search(intervals, intervals[i].end);
            indice[map.get(intervals[i])] = index == -1? -1 : map.get(intervals[index]);
        }
        return indice;
    }

    public int search(Interval[] inters, int val){
        int start = 0;
        int end = inters.length-1;
        int mid = 0;
        int min = Integer.MAX_VALUE;
        int min_i = -1;
        while(start <= end){
            mid = (start+end)/2;
            if(val < inters[mid].start){
                end = mid-1;
                if(inters[mid].start < min){
                    min = inters[mid].start;
                    min_i = mid;
                }
            }else if(val > inters[mid].start){
                start = mid + 1;
            }else{
                return mid;
            }
        }
        return min_i;
    }
    
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindRightInterval sln = new FindRightInterval();
		int [] res = sln.findRightInterval(new Interval[]{new Interval(3,4), new Interval(2,3), new Interval(1,2)});
		for(int i = 0 ;i < res.length; i++){
			System.out.print(res[i]+ " ");
		}
	}

}
class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}
