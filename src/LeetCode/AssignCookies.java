package LeetCode;

import java.util.Arrays;

public class AssignCookies {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        for(int i = 0, j = 0 ; i < g.length; i++){
            while(j < s.length && s[j] < g[i]){
                j++;
            }
            if(j == s.length){
                break;
            }else{
                count++;
                j++;
            }
        }
        return count;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
