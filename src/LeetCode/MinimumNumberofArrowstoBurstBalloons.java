package LeetCode;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberofArrowstoBurstBalloons {

    public int findMinArrowShots(int[][] points) {
        if(points.length < 2){
            return points.length;
        }
        Arrays.sort(points, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return a[1] == b[1]? a[0]-b[0]: a[1]-b[1];
            }
        });
        int count = 1; int last = points[0][1];
        for(int i = 1 ; i < points.length; i++){
            if(points[i][0] <= last) continue;
            else{
                count++;
                last = points[i][1];
            }
        }
        return count;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
