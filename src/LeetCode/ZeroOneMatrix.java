package LeetCode;

import java.util.*;

public class ZeroOneMatrix {

    public List<List<Integer>> updateMatrix(List<List<Integer>> matrix) {
        int [][] di = new int[][]{{0, 1},{0, -1},{1, 0},{-1, 0}};
        int n = matrix.size(), m = 0;
        List<List<Integer>> llist = new ArrayList<List<Integer>>();
        LinkedList<Integer> list = new LinkedList<Integer>();
        for(int i= 0 ; i < n; i++){
            m = matrix.get(i).size();
            llist.add(new ArrayList<Integer>());
            for(int j = 0 ; j < m; j++){
                llist.get(i).add(-1);
                if(matrix.get(i).get(j) == 0){
                    list.offer(encode(i, j));
                    llist.get(i).set(j, 0);
                }
            }
        }
        
        int f = 1;
        while(list.size() > 0){
            int k = list.size();
            
            for(int i = 0 ; i < k ;i ++){
                int[] xy = decode(list.poll());
                int x = xy[0];
                int y = xy[1];
                for(int j = 0; j < di.length ;j ++){
                    int x_next = x + di[j][0];
                    int y_next = y + di[j][1];
                    if(x_next >= 0 && x_next < n && y_next >= 0 && y_next < matrix.get(x_next).size()){
                        if(llist.get(x_next).get(y_next) == -1){
                            llist.get(x_next).set(y_next, f);
                            list.offer(encode(x_next, y_next));
                        }
                    }
                }
            }
            f++;
        }
        return llist;
        
    }
    
    public int encode(int x, int y){
        return (x << 16) | y;
    }
    
    public int[] decode(int key){
        int x = key >> 16;
        int y = key & 0xffff;
        return new int[]{x, y};
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
