package LeetCode;

public class DecodeString {

    public String decodeString(String s) {
        if(s == null || s.length() == 0) return "";
        String s1 = null, s2 = null, s3 = null, s4 = null;
        int index = 0;
        StringBuilder sb = new StringBuilder();
        while(index < s.length() && (s.charAt(index) > '9' || s.charAt(index) < '0')){
            index++;
        }
        s1 = s.substring(0,index);
        while(index < s.length() && s.charAt(index) <= '9' && s.charAt(index) >= '0'){
            sb.append(s.charAt(index));
            index++;
        }
        s2 = sb.toString();
        sb.setLength(0);
        if(index < s.length() && s.charAt(index) == '['){
            index++;
            int count = 0;
            while(index < s.length() && (s.charAt(index) != ']' || count > 0)){
                if(s.charAt(index) == '[') count++;
                if(s.charAt(index) == ']') count--;
                sb.append(s.charAt(index));
                index++;
            }
            index++;
            s3 = sb.toString();
            sb.setLength(0);
        }
        
        while(index < s.length()){
            sb.append(s.charAt(index));
            index++;
        }
        s4 = sb.toString();
        
        sb.setLength(0);
        sb.append(s1);
        int n = s2.length()>0?Integer.parseInt(s2):0;
        s3 = decodeString(s3);
        s4 = decodeString(s4);
        
        for(int i = 0; i < n; i++){
            sb.append(s3);
        }
        sb.append(s4);
        return sb.toString();
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DecodeString sln = new DecodeString();
		System.out.println(sln.decodeString("3[a]2[bc]"));
	}

}
