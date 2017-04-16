package LeetCode;
import java.math.BigInteger;

public class SmallestGoodBase {

    public String smallestGoodBase(String n) {
        BigInteger base = new BigInteger("2");
        BigInteger bi = new BigInteger(n);
        BigInteger bi2 = new BigInteger("1");
        while(base.compareTo(bi) < 0){
        	System.out.println("base:"+ base.toString());
            bi2 = new BigInteger("1");
            while(bi2.equals(BigInteger.ONE)){
                bi2 = bi.mod(base);
                System.out.println("bi2:"+ bi2.toString());
                bi = bi.subtract(bi2).divide(base);
                System.out.println("bi:"+ bi.toString());
            }
            if(bi.equals(BigInteger.ZERO) && bi2.equals(BigInteger.ZERO)){
                return base.toString();
            }
            base = base.add(BigInteger.ONE);
            bi = new BigInteger(n);
        }
        return null;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SmallestGoodBase sln = new SmallestGoodBase();
		String s = sln.smallestGoodBase("677");
		System.out.println(s);
	}

}
