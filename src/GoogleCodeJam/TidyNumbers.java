package GoogleCodeJam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class TidyNumbers {

	public static String getLastTidy(char [] s){
		int lastDecreased = 100000;
		for(int i = 1 ; i < s.length; i++){
			if(i > 0 && s[i]<s[i-1]){
				if(lastDecreased >= i){
					i = decrease(s, i);
					lastDecreased = Math.min(lastDecreased, i+1);
				}else{
					s[i] = '9';
				}
//				for(int j = 0 ; j < s.length; j++){
//					System.out.print(s[j]);
//				}
//				System.out.println(" : "+i);
			}
		}
		for(int i = 0; i < s.length; i++){
			if(s[i] > '0'){
				return new String(s, i, s.length - i); 
			}
		}
		return null;
	}
	
	public static int decrease(char [] s, int index){
		if(s[index] > '0'){
			s[index] -= 1;
			return index-1;
		}else if(index > 0){
			s[index] = '9';
			return decrease(s, index-1);
		}else{
			return 100000;
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String a = "12100";
//		char [] b = a.toCharArray();
//		a = getLastTidy(b);
//		System.out.println(a);
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
	      char[] s = in.next().toCharArray();
	      String res = getLastTidy(s);
	      System.out.println("Case #" + i + ": "+res);
	    }
	}

}
