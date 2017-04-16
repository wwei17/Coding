package LeetCode;

public class ComplexNumberMultiplication {

    public String complexNumberMultiply(String a, String b) {
    	String[] a1a2 = a.split("\\+");
    	String[] b1b2 = b.split("\\+");
    	int a1 = Integer.parseInt(a1a2[0]);
    	int a2 = Integer.parseInt(a1a2[1].substring(0, a1a2[1].length()-1));
    	int b1 = Integer.parseInt(b1b2[0]);
    	int b2 = Integer.parseInt(b1b2[1].substring(0, b1b2[1].length()-1));
    	int aa = a1*b1 - a2*b2;
    	int bb = a2*b1+a1*b2;
    	
        return aa+"+"+bb+"i";
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ComplexNumberMultiplication sln = new ComplexNumberMultiplication();
		String res = sln.complexNumberMultiply("1+1i", "1+1i");
		System.out.println(res);
	}

}
