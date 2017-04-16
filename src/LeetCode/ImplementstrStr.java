package LeetCode;

public class ImplementstrStr {

    public int strStr(String haystack, String needle) {
        if(haystack == null) return -1;
        if(needle.equals("")) return 0;
        for(int i = 0 ; i < haystack.length()-needle.length()+1; i++){
            if(haystack.substring(i, i+needle.length()).equals(needle)){
                return i;
            }
        }
        return -1;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
