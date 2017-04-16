package LeetCode;

import java.util.*;

public class QueueReconstructionbyHeight {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                if(a[0] == b[0]){
                    return Integer.compare(b[1], a[1]);
                }else{
                    return Integer.compare(a[0], b[0]);
                }
            }
        });
        
        int[][] res = new int[people.length][];
        int [] curr = null;
        int space_count = 0;
        int index = 0;
        for(int i =0; i <people.length; i++){
            curr = people[i];
            for(index = 0, space_count = 0; space_count < curr[1] ; index++){
                if(res[index] == null){
                    space_count++;
                }
            }
            while(res[index] != null){
                index++;
            }
            res[index] = people[i];
        }
        return res;
    } 
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueReconstructionbyHeight sln = new QueueReconstructionbyHeight();
		sln.reconstructQueue(new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}});
	}

}
