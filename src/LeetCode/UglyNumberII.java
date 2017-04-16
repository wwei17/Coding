package LeetCode;

import java.util.ArrayList;

public class UglyNumberII {

    public int nthUglyNumber(int n) {
        ArrayList<Integer> twoList = new ArrayList<Integer>();
        ArrayList<Integer> threeList = new ArrayList<Integer>();
        ArrayList<Integer> fiveList = new ArrayList<Integer>();
        int count = n;
        twoList.add(2);
        threeList.add(3);
        fiveList.add(5);
        int min = 0;
        int kth = 1;
        int two;int three;int five;
        while(count>1){
            two = twoList.get(0);
            three = threeList.get(0);
            five = fiveList.get(0);
            
            if(two > three){
                if(three > five){
                    fiveList.remove(0);
                    min = five;
                }else{
                    threeList.remove(0);
                    min = three;
                }
            }else{
                if(two > five){
                    fiveList.remove(0);
                    min = five;
                }else{
                    twoList.remove(0);
                    min = two;
                }
            }
            if(min != kth){
                kth = min;
                count--;
                twoList.add(min*2);
                threeList.add(min*3);
                fiveList.add(min*5);
            }
        }
        return kth;
        
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
