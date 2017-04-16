package LeetCode;

public class IntegerReplacement {

    public int integerReplacement(int n) {
        int count = 0;
        if(n == 1) return 0;
        if(n == 2) return 1;
        if(n == 3) return 2;
        if(n == Integer.MAX_VALUE) return 32;
        if((n & 1) ==0) {
            count = integerReplacement(n/2)+1;
        }else{
            count = (n+1)%4==0?integerReplacement(n+1)+1: integerReplacement(n-1)+1;
        }
        return count;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntegerReplacement sln = new IntegerReplacement();
		System.out.println(sln.integerReplacement(15));
	}

}
