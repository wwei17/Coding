package LeetCode;

import java.util.*;

public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ll = new ArrayList<List<Integer>>();
        int a1 = 0, a2 = 0;
        for(int i = 0; i < numRows; i++){
            ll.add(new ArrayList<Integer>());
            for(int j = 0; j < ll.size(); j++){
                if(i == 0) {
                    ll.get(i).add(1);
                    break;
                }else{
                    if(j == 0) a1 = 0;
                    else a1 = ll.get(i-1).get(j-1);
                    
                    if(j == ll.size()-1) a2=0;
                    else a2 = ll.get(i-1).get(j);
                    
                    ll.get(i).add(a1+a2);
                }
            }
        }
        return ll;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
