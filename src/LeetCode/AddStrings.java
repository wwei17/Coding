package LeetCode;

public class AddStrings {

    public String addStrings(String num1, String num2) {
        String max_s = null, min_s = null;
        if(num1.length() > num2.length()){
            max_s = num1;
            min_s = num2;
        }else{
            max_s = num2;
            min_s = num1;
        }
        char[] sum = new char[max_s.length()+1];
        int n1=0, n2=0, carry = 0, res = 0;
        int i = 0;
        for( ; i < min_s.length(); i++){
            n1 = max_s.charAt(max_s.length()-1-i)-'0';
            n2 = min_s.charAt(min_s.length()-1-i)-'0';
            res = (n1+n2+carry)%10;
            sum[sum.length-1-i] = (char)('0'+res);
            carry = (n1+n2+carry)/10;
        }
        for( ; i < max_s.length(); i++){
            n1 = max_s.charAt(max_s.length()-1-i)-'0';
            res = (n1+carry)%10;
            sum[sum.length-1-i] = (char)('0'+res);
            carry = (n1+carry)/10;
        }
        if(carry == 1){
            sum[0] = '1';
            return new String(sum);
        }else{
            return new String(sum, 1, sum.length-1);
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddStrings sln  =new AddStrings();
		System.out.println(sln.addStrings("0","0"));
	}

}
