package LeetCode;

public class DetectCapital {

    public boolean detectCapitalUse(String word) {
        if(word.length() < 2){
            return true;
        }else{
            char offset = 'a';
            if(word.charAt(1) <= 'Z'){
                if(word.charAt(0) <= 'Z') offset = 'A';
                else return false;
            }
            for(int i = 2 ;i < word.length(); i++){
                char c = word.charAt(i);
                if(c-offset < 0 || c-offset > 26) return false;
            }
            return true;
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
