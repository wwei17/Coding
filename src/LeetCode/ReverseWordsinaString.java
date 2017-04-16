package LeetCode;

public class ReverseWordsinaString {

    public String reverseWords(String s) {
        String[] ss = s.trim().split("\\s+");
        StringBuffer rs = new StringBuffer();
        for(int i =ss.length -1; i >= 0; i--){
            //if(!ss[i].equals(""))
                rs.append(ss[i] + " ");
        }
        return rs.toString().trim();
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
