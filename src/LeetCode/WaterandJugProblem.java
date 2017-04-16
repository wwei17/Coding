package LeetCode;

import java.util.HashSet;

public class WaterandJugProblem {

    public boolean canMeasureWater(int x, int y, int z) {
        HashSet<Integer> set = new HashSet<Integer>();
        HashSet<Integer> set2 = new HashSet<Integer>();
        if(x > y){
            y = x^y;
            x = y^x;
            y = y^x;
        }
        if(x == 0) return y == z || z == 0;
        set.add(0);
        set.add(x);
        set.add(y);
        set.add(x+y);
        int y2 = y, x2 = x;
        do{
            set2.add(x2);
            while(y2 > x){
                 set.add(y2-x);
                 y2 -= x;
            }
            x2 = y2;
            set.add(y2+y);
            y2 = y-x+y2;
            set.add(y2);
        }while(!set2.contains(x2));
        return set.contains(z);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
