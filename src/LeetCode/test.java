package LeetCode;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(782%3);
	}
	  public static int countDigits( int num ){  
		     int count =0;
		     while( num != 0 ){
		       num = num / 10;
		       count ++;   
		     }
		     return ( num % count );
		  } 
}
