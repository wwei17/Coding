package LeetCode;

import java.math.BigInteger;

public class UniquePaths {

    public int uniquePaths(int m, int n) {
        BigInteger result = factor(m+n-2).divide(factor(m-1).multiply(factor(n-1)));
        return result.intValue();
    }
    
    public BigInteger factor(int n){
        if(n > 1){
            return factor(n-1).multiply(BigInteger.valueOf(n));
        }else{
            return BigInteger.valueOf(1);
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
