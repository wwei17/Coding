package LeetCode;

public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        int i = 0, j = s.length()-1;
        s = s.toLowerCase();
        while(i < j){
            while(i<j && !(((s.charAt(i) <= 'z') && (s.charAt(i) >= 'a')) || ((s.charAt(i) <= '9') && (s.charAt(i) >= '0')))){
                i++;
            } 
            while(i<j && !(((s.charAt(j) <= 'z') && (s.charAt(j) >= 'a')) || ((s.charAt(j) <= '9') && (s.charAt(j) >= '0')))){
                j--;
            } 
            if(i<j && s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
