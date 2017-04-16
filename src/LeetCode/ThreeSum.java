package LeetCode;

import java.util.*;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] num) {
        
        List<List<Integer>> ll = new ArrayList<List<Integer>>();
        Arrays.sort(num);

        //HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();
        //HashMap<Integer, Integer> map2 = new HashMap<Integer, Integer>();
        //HashMap<Integer, Integer> map0 = new HashMap<Integer, Integer>();
        int p1; int p2;
        int error;
        for(int i = 0 ; i < num.length-2; i++){
            p1 = i+1; p2 = num.length -1;
            if(i>0 && num[i] == num[i-1]) continue;
            while(p1 < p2){
            	error = num[i] + num[p1] + num[p2];
                if((p1 <= i+1 || num[p1] != num[p1-1]) && (p2 >= num.length-1 || num[p2] != num[p2+1])){ 
                	
                	if(error == 0){
                	//if(!(map0.containsKey(num[i]) && map0.get(num[i])==0 && map1.containsKey(num[p1]) && map1.get(num[p1])==1 && map2.containsKey(num[p2]) && map2.get(num[p2])==2)){
	                
                		List<Integer> l = new ArrayList<Integer>();
	                    l.add(num[i]);
	                    l.add(num[p1]);
	                    l.add(num[p2]);
	                    ll.add(l);
                	}
                }
                if(error > 0){
                    p2 --;
                }else{
                    p1 ++;
                }
            }
        }
        return ll;
    }

    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int [] s = {-13,10,11,-3,8,11,-4,8,12,-13,5,-6,-4,-2,12,11,7,-7,-3,10,12,13,-3,-2,6,-1,14,7,-13,8,14,-10,-4,10,-6,11,-2,-3,4,-13,0,-14,-3,3,-9,-6,-9,13,-6,3,1,-9,-6,13,-4,-15,-11,-12,7,-9,3,-2,-12,6,-15,-10,2,-2,-6,13,1,9,14,5,-11,-10,14,-5,11,-6,6,-3,-8,-15,-13,-4,7,13,-1,-9,11,-13,-4,-15,9,-4,12,-4,1,-9,-5,9,8,-14,-1,4,14};
		int [] s = {7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6};
		ThreeSum ts = new ThreeSum();
		List<List<Integer>> ll = ts.threeSum(s);
		System.out.println(ll.size());
		for(int i = 0 ; i < ll.size();i++){
			for(int j = 0; j <ll.get(i).size(); j++){
				System.out.print(ll.get(i).get(j)+" ");
			}
			System.out.println();
		}
	}

}
