package LeetCode;

import java.util.*;

public class SuperUglyNumber {

    public int nthSuperUglyNumber(int n, int[] primes) {

        if(n == 1){
            return 1;
        }else{
            PriorityQueue<Number> pq = new PriorityQueue<Number>(primes.length, new NumberComparator());
            ArrayList<Integer> l = new ArrayList<Integer>();
            l.add(1);
            for(int i = 0 ; i < primes.length; i++){
                pq.offer(new Number(primes[i]));
            }
            int nth; Number temp;
            for(int i = 0 ; i < n-2; i++){
                nth = pq.peek().val;
                l.add(nth);
                while(pq.peek().val == nth){
                    temp = pq.poll();
                    temp.count++;
                    temp.val = l.get(temp.count)*temp.prime;
                    pq.offer(temp);
                    
                }
            }
            return pq.peek().val;
        }
    }
    
    class Number{
        int count;
        int prime;
        int val;
        Number(int p){
            prime = p;
            count = 0;
            val = p;
        }
    }
    
    class NumberComparator implements Comparator<Number>{
        @Override
        public int compare(Number x, Number y){
            return x.val -y.val;
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] primes = {2,7,13,19};
		SuperUglyNumber sln = new SuperUglyNumber();
		
		System.out.println(sln.nthSuperUglyNumber(12, primes));
	}

}
