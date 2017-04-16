package LeetCode;

import java.util.*;

public class ThreeSumClosest {

    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        int p1;
        int p2;
        int error=Integer.MAX_VALUE;
        for(int i = 0; i < num.length; i++){
        	int subtarget = target - num[i];
        	//error = Integer.MAX_VALUE;
        	for(p1=i+1, p2=num.length-1; p1< p2; ){
        		if(Math.abs(num[p1]+num[p2]-subtarget) < Math.abs(error)){
        			error = num[p1]+num[p2] - subtarget;
        			if(error == 0) return target;
        		}
        		if(Math.abs(num[p1+1]+num[p2]-subtarget) < Math.abs(num[p1]+num[p2-1]-subtarget)){
        			p1++;
        		}else{
        			p2--;
        		}
        	}
        }
        
        return target+error;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreeSumClosest s = new ThreeSumClosest();
		int[] a = {-1, 2, 1, -4};
		System.out.println(s.threeSumClosest(a, 1));
	}

}
