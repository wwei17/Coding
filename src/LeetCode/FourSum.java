package LeetCode;

import java.util.*;

public class FourSum {

    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> ll = new ArrayList<List<Integer>>();
        int p1; int p2;
        Arrays.sort(num);
        for(int i = 0 ; i < num.length-3; i++){
        	if(i > 0 && num[i] == num[i-1]) continue;
        	for(int j = i+1; j < num.length-2; j++){
        		if(j > i+1 && num[j] == num[j-1]) continue;
        		p1 = j+1; p2 = num.length-1;
        		while(p1 < p2){
        			if(p1>j+1 && num[p1] == num[p1-1]){
        				p1++; continue;
        			}
        			if(p2 < num.length-1 && num[p2] == num[p2+1]){
        				p2--; continue;
        			}
        			int error_local = target - num[i] - num[j] - num[p1] - num[p2];
        			if(error_local == 0){
        				List<Integer> l = new ArrayList<Integer>();
        				l.add(num[i]);
        				l.add(num[j]);
        				l.add(num[p1]);
        				l.add(num[p2]);
        				ll.add(l);
        				p1++;
        				p2--;
        			}else if(error_local > 0){
        				p1++;
        			}else{
        				p2--;
        			}
        			
        			
        		}
        	}
        }
        
        return ll;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] s = {1,0,-1,0,-2,2};
		int t = 0;
		FourSum fs = new FourSum();
		List<List<Integer>> ll = fs.fourSum(s,0);
		System.out.println(ll.size());
		for(int i = 0 ; i < ll.size();i++){
			for(int j = 0; j <ll.get(i).size(); j++){
				System.out.print(ll.get(i).get(j)+" ");
			}
			System.out.println();
		}
	}
}
