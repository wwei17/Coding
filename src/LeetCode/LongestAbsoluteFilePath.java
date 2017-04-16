package LeetCode;

import java.util.Stack;

public class LongestAbsoluteFilePath {

    public int lengthLongestPath(String input) {
        Stack<Integer> st = new Stack<Integer>();
        int count = 0; int len = 0;  int max = 0 ;
        int flag = 0; int pre_flag = -1;
        int index = 0; boolean is_file= false;
        while(index < input.length()){
            char c = input.charAt(index);
            if(c == '\n'){
                while(flag <= pre_flag){
                    count -= st.pop()+1;
                    pre_flag --;
                }
                st.push(len);
                count += len+1;
                if(is_file){
                    max = Math.max(max, count);
                }
                len = 0;
                pre_flag = flag;
                flag = 0;
                is_file = false;
            }else if(c == '\t'){
                flag++;
            }else{
                if(c == '.') is_file = true;
                len++;
            }
            index++;
        }
        if(is_file){
            while(flag <= pre_flag){
                count -= st.pop()+1;
                pre_flag --;
            }
            count += len+1;
            max = Math.max(max, count);
        }
        return max > 0? max - 1: 0;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestAbsoluteFilePath sln = new LongestAbsoluteFilePath();
		System.out.println(sln.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
	}

}
