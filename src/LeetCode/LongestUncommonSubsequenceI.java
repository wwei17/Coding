package LeetCode;

public class LongestUncommonSubsequenceI {

    public int findLUSlength(String a, String b) {
        if( a.length() > b.length()){
            return a.length();
        }else if(a.length() < b.length()){
            return b.length();
        }else{
            return a.equals(b)? -1: a.length();
        }
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
