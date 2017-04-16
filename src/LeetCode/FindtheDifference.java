package LeetCode;

public class FindtheDifference {

    public char findTheDifference(String s, String t) {
        char extra = 0;
        for(int i = 0; i < s.length(); i++){
            extra ^= s.charAt(i);
        }
        for(int i = 0; i < t.length(); i++){
            extra ^= t.charAt(i);
        }
        return extra;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
