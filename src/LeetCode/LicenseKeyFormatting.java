package LeetCode;

public class LicenseKeyFormatting {

    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        char c = ' '; 
        for(int i = S.length()-1, j = 0; i >=0; i--){
            c = S.charAt(i);
            if(c !='-'){
                if(j%K == 0 && sb.length()>0){
                    sb.append('-');
                }
                if(c >= 'a' && c <='z'){
                    sb.append((char)('A'-'a'+c));
                }else{
                    sb.append(c);
                }
                j++;
                
            }
        }
        return sb.reverse().toString();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
