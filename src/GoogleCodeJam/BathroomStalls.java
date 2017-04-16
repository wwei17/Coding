package GoogleCodeJam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BathroomStalls {

	class LS{
		long min;
		long max;
		LS(long max, long min){
			this.min = min;
			this.max = max;
		}
	}
	
	public LS getLS(long n, long k){
		HashMap<Long, Long> map = new HashMap<Long, Long>();
		PriorityQueue<Long> q = new PriorityQueue<Long>(Collections.reverseOrder());
		map.put(n, (long)1);
		q.offer(n);
		long nq = 0, nq1 = 0, nq2 = 0;
		while(k > 0){
			nq = q.poll();
			long mq = map.get(nq);
			k-= mq;
			nq--;
			nq1 = nq >> 1;
			nq2 = nq1+ (nq&1);
			if(map.containsKey(nq1)){
				map.put(nq1, map.get(nq1)+mq);
			}else{
				map.put(nq1, mq);
				q.offer(nq1);
			}
			if(map.containsKey(nq2)){
				map.put(nq2, map.get(nq2)+mq);
			}else{
				map.put(nq2, mq);
				q.offer(nq2);
			}
		}
		return new LS(nq2, nq1);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BathroomStalls sln = new BathroomStalls();
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
	      long n = in.nextLong();
	      long k = in.nextLong();
	      LS ls = sln.getLS(n, k);
	      System.out.println("Case #" + i + ": "+ls.max + " "+ ls.min);
	    }
	}

}
