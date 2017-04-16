package LeetCode;

public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        StringBuffer ss = new StringBuffer("");
        
        for(int i = 0; i < s.length(); i ++){
            ss.append('#');
            ss.append(s.charAt(i));
        }
        ss.append('#');
        
        int c = 0;
        int r = 0, l = 0 , j = 0, j_m = 0;
        int[] counter = new int[2*s.length()+1];
        while(j < ss.length()){
            j_m = 2*c - j;
            if(r >= j){
                counter[j] = Math.min(r-j, counter[j_m]);
            }else{
                counter[j] = 0;
            }
            
            while((j+counter[j]+1 < ss.length()) && (j-counter[j]-1 >= 0) && ss.charAt(j+counter[j]+1) == ss.charAt(j-counter[j]-1)){
                counter[j]++;
            }
            
            if(j+counter[j] > r){
                c = j;
                r = j + counter[j];
            }
            
            j++;
        }
        
        int max = 0; int max_i = 0;
        for(int i = 0; i < counter.length; i++){
            if(counter[i] > max){
                max = counter[i];
                max_i = i;
            }
        }
        
        StringBuffer ns = new StringBuffer("");
        for(int i =0; i < max*2 + 1; i++){
            if(ss.charAt(max_i-max+i) != '#'){
                ns.append(ss.charAt(max_i-max+i));
            }
        }
        return ns.toString();
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
