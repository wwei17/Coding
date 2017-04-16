package GoogleCodeJam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class OversizedPancakeFlipper {

	public static String getMinFlip(char[] token, int k){
		int count = 0;
		for(int i = 0; i+k-1 < token.length; i++){
			if(token[i] == '-'){
				count++;
				for(int j = 0; j < k && i+k-1 < token.length; j++){
					token[i+j] = token[i+j]=='-'? '+':'-';
				}
//				for(int j = 0 ; j < token.length; j++){
//					System.out.print(token[j]);
//				}
//				System.out.println();
			}
		}
		for(int i = 0; i < token.length; i++){
			if(token[i] == '-'){
				return "IMPOSSIBLE";
			}
		}
		return count+"";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
	      String token = in.next();
	      int k = in.nextInt();
	      String res = getMinFlip(token.toCharArray(), k);
	      System.out.println("Case #" + i + ": "+res);
	    }
	}

}
