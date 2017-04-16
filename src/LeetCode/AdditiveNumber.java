package LeetCode;

public class AdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        long n1 = 0, n2 = 0;
        boolean flag = true;
        int len = num.length();
        String s1, s2;
        for(int i = 0; i < len/2; i++){
            for(int j = i+1; len-1 - j >= Math.max(i+1, j-i) ; j++){
                flag = true;
                s1 = num.substring(0, i+1); 
                if(i > 0 && s1.charAt(0) == '0') flag =  false;
                n1 = Long.parseLong(s1);
                s2 = num.substring(i+1, j+1);
                if(j-i > 1 && s2.charAt(0) == '0') flag =  false;
                n2 = Long.parseLong(s2);
                flag = flag && isAdditiveNumber(n1, n2, num.substring(j+1));
                if(flag) return true;
            }
        }
        return false;
    }
    
    public boolean isAdditiveNumber(long n1, long n2, String num){
        long n3 = n2+n1;
        String s3 = n3+"";
        int len = s3.length();
        if(num.charAt(0) == '0'){
            return false;
        }else if(num.length() < len){
            return false;
        }else if(num.length() == len){
            return num.equals(s3);
        }else{
            return num.substring(0, len).equals(s3) && isAdditiveNumber(n2, n3, num.substring(len));
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdditiveNumber sln = new AdditiveNumber();
		System.out.println(sln.isAdditiveNumber("221474836472147483649"));

	}

}
