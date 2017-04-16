package LeetCode;

import java.util.*;

public class PascalsTriangleII {

    public List<Integer> getRow(int rowIndex) {
        
        List<Integer> l = new ArrayList<Integer>();
        if(rowIndex >= 0){
            l.add(1);
        }
        for(int i = 0 ; i < rowIndex; i++){
            l.add((int)((long)l.get(i-1+1)*(rowIndex-i)/(i+1)));
        }
        return l;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
