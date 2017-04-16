package LeetCode;

public class PerfectNumber {
    public boolean checkPerfectNumber(int num) {
    	if(num <= 1) return false;
        int sum = -num; 
        int p = 1;
        long pp = p*p;
        while(pp <= num){
        	sum += p + num/p;
            p++;
            while(num % p > 0){
                p++;
            }
            pp = (long)p*(long)p;
        }
        return sum == num;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PerfectNumber sln = new PerfectNumber();
		System.out.println(sln.checkPerfectNumber(1));
	}

}
