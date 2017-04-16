package LeetCode;

import java.util.Arrays;

public class RemoveKDigits {

    public String removeKdigits(String num, int k) {
        int index = 0;
        char[] min_num = new char[num.length()-k];
        if( min_num.length == 0) return "0";
        for(int i = 0 ; i < num.length() && index < min_num.length; i ++){
            char min = '9'; int min_j = i;
            for(int j = 1 ; j <= k && i + j < num.length(); j++){
                if(num.charAt(i+j) < min){
                    min_j = i + j;
                    min = num.charAt(i + j);
                }
            }
            if(num.charAt(i) > min){
                k -= min_j - i;
                min_num[index] = min;
                i += min_j - i;
            }else{
                min_num[index] = num.charAt(i);
            }
            index++;
        }
        int i = 0 ; 
        while(i < min_num.length && min_num[i] == '0'){
        	i++;
        }
        if(i == min_num.length){
            return "0";
        }
        return new String(min_num, i, min_num.length-i);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveKDigits sln = new RemoveKDigits();
		System.out.println(sln.removeKdigits("10200", 1));
	}

}
