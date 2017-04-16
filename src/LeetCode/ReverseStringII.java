package LeetCode;

public class ReverseStringII {

    public String reverseStr(String s, int k) {
        int i = 0;
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        while(i < n){
            for(int j = Math.min(i+k-1, n-1) ; j >= i; j--){
                sb.append(s.charAt(j));
            }
            i+=k;
            for(int j = i; j < Math.min(i+k, n); j++){
                sb.append(s.charAt(j));    
            }
            i+=k;
        }
        return sb.toString();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
