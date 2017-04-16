package LeetCode;

import java.util.HashSet;

public class FrogJump {

    public boolean canCross(int[] stones) {
        HashSet<Integer> map = new HashSet<Integer>();
        return canCross(stones, 0, 0, map);
    }
    
    public boolean canCross(int[] stones,int curr,int span, HashSet<Integer> map){
        int i = 0; int dif = 0;int temp = 0;
        do{
            i++; 
            if(curr+i >= stones.length) return false;
            dif = stones[curr+i] - stones[curr];
            if(dif >= span-1 && dif<=span+1){
                temp = (curr+i) | (dif << 11);
                if(curr+i == stones.length-1){
                    return true;
                }
                if(!map.contains(temp)){
                    if(canCross(stones, curr+i, dif, map)){
                        return true;
                    }else{
                        map.add(temp);
                    }
                }
            }else if(dif>span+1){
                break;
            }
            
        }while(true);
        return false;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FrogJump sln = new FrogJump();
		System.out.println(sln.canCross(new int[]{0,1,3,4,5,7,9,10,12}));
	}

}
