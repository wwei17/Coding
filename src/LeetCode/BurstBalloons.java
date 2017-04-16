package LeetCode;

import java.util.ArrayList;

public class BurstBalloons {
    public int maxCoins(int[] nums) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(1);
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                a.add(nums[i]);
            }
        }
        a.add(1);
        
        int len = a.size();
        int [][] c = new int[len][len];
        int temp;
        for(int i = 2; i<len; i++){
            for(int l=0; l<len-i; l++){
                int r = l+i;
                for(int j =l+1; j< r; j++){
                    temp = c[l][j]+a.get(l)*a.get(j)*a.get(r)+c[j][r];
                    if(temp > c[l][r]){
                        c[l][r] = temp;
                    }
                }
            }
        }
        return c[0][len-1];
            
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
