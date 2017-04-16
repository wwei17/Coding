package LeetCode;

public class VerifyPreorderSerializationofaBinaryTree {

    public boolean isValidSerialization(String preorder) {
        int count_n = 0;
        int count_c = 0;
        int i = 0;
        char c = ' '; char prev_c = ' ';
        while(i < preorder.length()){
            if(count_c == count_n + 1){
                return false;
            }
            c = preorder.charAt(i);
            if(c == ','){
                if(prev_c == '#'){
                    count_c++;
                }else{
                    count_n++;
                }
            }
            prev_c = c;
            i++;
        }
        return count_c == count_n && prev_c == '#';
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
