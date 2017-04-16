package LeetCode;

import java.util.*;

public class NumberofBoomerangs {

    public int numberOfBoomerangs(int[][] points) {
        int[][] dis = new int[points.length][points.length];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0 ; i < dis.length; i++){
            for(int j = 0 ; j < dis.length; j++){
                dis[i][j] = get_distance(points[i], points[j]);
            }
        }
        int count = 1; int res = 0;
        for(int i = 0 ; i < dis.length; i++){
            map.clear();
            for(int j = 0 ; j < dis.length; j++){
                count = map.getOrDefault(dis[i][j], 0);
                res -= count*(count-1);
                map.put(dis[i][j], count+1);
                res += count*(count+1);
            }
        }
        return res;
    }
    public int get_distance(int[] p1, int[]p2){
        return (p1[0]-p2[0])*(p1[0]-p2[0])+(p1[1]-p2[1])*(p1[1]-p2[1]);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] points = {{0,0},{1,0},{-1,0},{0,1},{0,-1}};
		NumberofBoomerangs sln = new NumberofBoomerangs();
		System.out.println(sln.numberOfBoomerangs(points));
	}

}
