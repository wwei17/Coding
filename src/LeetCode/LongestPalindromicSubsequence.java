package LeetCode;

public class LongestPalindromicSubsequence {

    public int longestPalindromeSubseq(String s) {
        int [][] counts = new int[s.length()][s.length()];
        return helper(s, counts, 0, s.length()-1);
    }
    
    public int helper(String s, int[][] counts, int start, int end){
        if(counts[start][end] > 0){
            return counts[start][end];
        }    
        if(start == end){
            counts[start][end] = 1;
            return 1;
        }
        if(start > end){
            return 0;
        }
        if(s.charAt(start) == s.charAt(end)){
            counts[start][end] = helper(s, counts, start+1, end-1)+2;
        }else{
            counts[start][end] = Math.max(helper(s, counts, start+1, end), helper(s, counts, start, end-1));
        }
        return counts[start][end];
        
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
