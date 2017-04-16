package LeetCode;

public class CountandSay {

    public String countAndSay(int n) {
        if(n <= 0) return "";
        else if(n == 1) return "1";
        StringBuffer sb = new StringBuffer("");
        String s = "1";
        for(int i = 0 ; i < n-1; i++){
            int j = 0; int k = 0;
            int count = 1;
            while(k < s.length()){
                if(s.charAt(j) == s.charAt(k)){
                    if(j != k){
                        count ++;
                    }else{
                        
                    }
                }else{
                    j = k;
                    sb.append(count);
                    sb.append(s.charAt(k-1));
                    count = 1;
                }
                k++;
            }
            sb.append(count);
            sb.append(s.charAt(k-1));
            s=sb.toString();
            sb.setLength(0);
        }
        return s;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
