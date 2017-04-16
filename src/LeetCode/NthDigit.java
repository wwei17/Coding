package LeetCode;

public class NthDigit {

    public int findNthDigit(int n) {
        long k = 9; int m = 1;
        while(n > k*m){
            n -= k*m;
            k *= 10;
            m++;
        }
        int n2 = (n-1)/m + (int)Math.pow(10, m-1);
        int m2 = (int)Math.pow(10,m-((n+m-1)%m));
        return (n2 % m2)/(m2/10);
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NthDigit sln = new NthDigit();
		System.out.println(sln.findNthDigit(1000000000));
	}

}
