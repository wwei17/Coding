package LeetCode;

import java.util.*;

public class LexicographicalNumbers {

    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<Integer>();
        return lexicalOrder(n, 0, list);
    }
    public List<Integer> lexicalOrder(int n, int curr, List<Integer> list) {
        int i = curr==0? 1:0; int res = curr*10+i;
        while(res <= n && i < 10){
            list.add(res);
            i++;
            lexicalOrder(n, res,list);
            res = curr*10+i;
        }
        return list;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
