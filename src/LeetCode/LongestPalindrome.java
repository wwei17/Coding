package LeetCode;

public class LongestPalindrome {

    public int longestPalindrome(String s) {
        int[] count = new int[128];
        int odd_count = 0;
        int even_count = 0;
        char c = ' ';
        int c_index = 0;
        for(int i = 0 ; i < s.length(); i++){
            c = s.charAt(i);
            c_index =(int)c; 
            count[c_index]++;
            if(count[c_index]%2 == 1){
                odd_count++;
            }else{
                even_count++;
                odd_count--;
            }
        }
        return (odd_count>0?1:0)+ even_count*2;
        
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
