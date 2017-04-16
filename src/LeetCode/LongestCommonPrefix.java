package LeetCode;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if(strs == null) return null;
        if(strs.length == 0) return "";
        if(strs.length == 1) return strs[0];
        StringBuffer prefix = new StringBuffer("");
        String s = strs[0];
        
        for(int i = 0; i < strs[0].length(); i++){
            char a = strs[0].charAt(i);
            for(int j = 1; j < strs.length; j++){
                if(i == strs[j].length()){
                    return prefix.toString();
                }else{
                    if(strs[j].charAt(i) != a){
                        return prefix.toString();
                    }
                }
            }
            prefix.append(a);
            
        }
        return prefix.toString();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
