package GoogleCodeJam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class AlphabetCake {

	public boolean nameCake(char[][] cake, int i, int j){
		
		int next_i = 0 ; int next_j = 0;
		if(j < cake[i].length-1){
			next_i = i; 
			next_j = j+1;
		}else if(i < cake.length -1){
			next_i = i+1;
			next_j = 0;
		}
		
		if(cake[i][j] <= 'Z' && cake[i][j] >= 'A'){
			fillH(cake, i, j, false);
		}
		
		if(i == cake.length -1 && j == cake[i].length-1){
			boolean res =  countEmpty(cake);
			if(!res && cake[i][j] <= 'Z' && cake[i][j] >= 'A'){
				fillH(cake, i, j, true);
				fillV(cake, i, j, false);
				res =  countEmpty(cake);
				if(!res) fillV(cake, i, j, true);
				return res;
			}else{
				return res;
			}
		}else{
		
			boolean res = nameCake(cake, next_i, next_j);
			if(!res && cake[i][j] <= 'Z' && cake[i][j] >= 'A'){
				fillH(cake, i, j, true);
				fillV(cake, i, j, false);
				res =  nameCake(cake, next_i, next_j);
				if(!res) fillV(cake, i, j, true);
				return res;
			}else{
				return res;
			}
		}
		
	}
	public boolean countEmpty(char[][] cake){
		int count = 0;
		for(int i = 0 ; i< cake.length; i++){
			for(int j  = 0 ; j<cake[i].length; j++){
				count += cake[i][j] == '?'? 1:0;
			}
		}
		return count == 0;
	}
	
	public void fillH(char[][] cake, int i, int j, boolean reverse){
		char c = (char)(cake[i][j]+32);
		int p = j;
		if(!reverse){
			p--;
			while(p >=0 && cake[i][p] == '?'){
				cake[i][p] = c;
				p--;
			}
			p = j+1;
			while(p < cake[i].length && cake[i][p] == '?'){
				cake[i][p] = c;
				p++;
			}
		}else{
			p--;
			while(p >=0 && cake[i][p] == c){
				cake[i][p] = '?';
				p--;
			}
			p = j+1;
			while(p < cake[i].length && cake[i][p] == c){
				cake[i][p] = '?';
				p++;
			}
		}
	}
	public void fillV(char[][] cake, int i, int j, boolean reverse){
		char c = (char)(cake[i][j]+32);
		int p = i;
		if(!reverse){
			p--;
			while(p >=0 && cake[p][j] == '?'){
				cake[p][j] = c;
				p--;
			}
			p = i+1;
			while(p < cake.length && cake[p][j] == '?'){
				cake[p][j] = c;
				p++;
			}
		}else{
			p--;
			while(p >=0 && cake[p][j] == c){
				cake[p][j] = '?';
				p--;
			}
			p = j+1;
			while(p < cake.length && cake[p][j] == c){
				cake[p][j] = '?';
				p++;
			}
		}
	}
	
	public void toUpCase(char[][] cake){
		for(int i = 0 ; i< cake.length; i++){
			for(int j  = 0 ; j<cake[i].length; j++){
				if(cake[i][j] >= 'a'){
					cake[i][j] = (char)(cake[i][j]-32);
				}
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AlphabetCake sln = new AlphabetCake();
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			int R = in.nextInt();
			int C = in.nextInt();
			char[][] cake = new char[R][C];
			for(int j = 0 ; j < R; j++){
				cake[j] = in.next().toCharArray();
			}
			System.out.println("Case #:"+i);
			//printCharArray(cake);
			sln.nameCake(cake, 0,0);
			//printCharArray(cake);
			sln.toUpCase(cake);
			printCharArray(cake);
	    }
	}
	public static void printCharArray(char[][] array){
		for(int k = 0 ; k< array.length; k++){
			for(int j  = 0 ; j<array[k].length; j++){
				System.out.print(array[k][j]);
			}
			System.out.println();
		}
	}
}
