package LeetCode;

import java.util.*;

public class MinimumTimeDifference {

    public int findMinDifference(List<String> timePoints) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int n = timePoints.size();
        for(int i = 0; i < n; i++){
            String s = timePoints.get(i);
            int time = (s.charAt(4)-'0')+(s.charAt(3)-'0')*10+((s.charAt(1)-'0')+(s.charAt(0)-'0')*10)*60;
            list.add(time);
        }
        Collections.sort(list);
        int dif_min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            dif_min = Math.min((list.get((i+1)%n)-list.get(i)+1440)%1440, dif_min);    
        }
        return dif_min;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
