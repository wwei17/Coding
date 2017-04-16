package LeetCode;

import java.util.HashSet;

public class PerfectRectangle {

    public boolean isRectangleCover(int[][] rectangles) {
        int min_x = Integer.MAX_VALUE;
        int min_y = Integer.MAX_VALUE;
        int max_x = Integer.MIN_VALUE;
        int max_y = Integer.MIN_VALUE;
        int area = 0;
        HashSet<String> set = new HashSet<String>();
        String s = "";
        for(int i = 0 ; i < rectangles.length; i++){
            min_x = Math.min(min_x, rectangles[i][0]);
            min_y = Math.min(min_y, rectangles[i][1]);
            max_x = Math.max(max_x, rectangles[i][2]);
            max_y = Math.max(max_y, rectangles[i][3]);
            
            area += (rectangles[i][2]-rectangles[i][0])*(rectangles[i][3]-rectangles[i][1]);
            
            s=rectangles[i][0]+","+rectangles[i][1];
            if(set.contains(s)) set.remove(s); else set.add(s);
            s=rectangles[i][0]+","+rectangles[i][3];
            if(set.contains(s)) set.remove(s); else set.add(s);
            s=rectangles[i][2]+","+rectangles[i][1];
            if(set.contains(s)) set.remove(s); else set.add(s);
            s=rectangles[i][2]+","+rectangles[i][3];
            if(set.contains(s)) set.remove(s); else set.add(s);
            
        }
        
        return set.contains(min_x+","+min_y) && set.contains(min_x+","+max_y) && set.contains(max_x+","+min_y) && set.contains(max_x+","+max_y) && set.size()==4 && (max_x-min_x)*(max_y-min_y)==area;

    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PerfectRectangle sln = new PerfectRectangle();
		sln.isRectangleCover(new int[][]{{1,1,3,3},{3,1,4,2},{3,2,4,4},{1,3,2,4},{2,3,3,4}});
	}

}
