package LeetCode;

import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int min = Integer.MAX_VALUE;
        int temp;
        if(triangle.size() == 0){
            return 0;
        }else if(triangle.size() ==1){
            return triangle.get(0).get(0);
        }
        for(int i = 1; i < triangle.size(); i++){
            min = Integer.MAX_VALUE;
            for(int j = 0 ; j < triangle.get(i).size(); j++){
                if(i != 0){
                    if(j == 0){
                        temp = triangle.get(i-1).get(j)+triangle.get(i).get(j);
                    }else if(j == triangle.get(i).size()-1){
                        temp = triangle.get(i-1).get(j-1)+triangle.get(i).get(j);
                    }else{
                        temp = Math.min(triangle.get(i-1).get(j-1)+triangle.get(i).get(j), triangle.get(i-1).get(j)+triangle.get(i).get(j));
                    }
                    if(temp < min) min = temp;
                    triangle.get(i).set(j,temp);
                }
            }
        }
        return min;
        
    }
}
