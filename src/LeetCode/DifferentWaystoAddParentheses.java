package LeetCode;

import java.util.*;

public class DifferentWaystoAddParentheses {

    public List<Integer> diffWaysToCompute(String input) {
        int curr = 0; char c = ' ';
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < input.length();i++){
            c = input.charAt(i);
            if(c >='0' && c <='9'){
                curr = curr*10+c-'0';
            }else{
                list.add(curr);
                curr=0;
                list.add((int)c);
            }
        }
        list.add(curr);
        int[] pos = new int[list.size()];
        for(int i = 0; i < pos.length; i++){
            pos[i] = i+1;
        }
        List<Integer> res = new ArrayList<Integer>();
        diffWaysToComputeRes(list, pos, res);
        return res;
    }
    
    public void diffWaysToComputeRes(ArrayList<Integer> token, int[] pos, List<Integer> res){
        if(pos[0] == pos.length) {
            res.add(token.get(0));
        }else{
            int a = 0, op = 0, b = 0;
            int c = 0; int prev = 0;
            for(int i = 0 ; pos[i] < pos.length; i = pos[pos[i]]){
                a = token.get(i);
                prev = pos[i];
                op = token.get(pos[i]);
                b = token.get(pos[pos[i]]);
                c = calculating(a, op, b);
                token.set(i, c);
                pos[i] = pos[pos[pos[i]]];
                diffWaysToComputeRes(token, pos, res);
                token.set(i, a); 
                pos[i] = prev;
            }
        }
    }
    
    public int calculating(int a, int op, int b){
        if(op == (int)'+') return a+b;
        if(op == (int)'-') return a-b;
        if(op == (int)'*') return a*b;
        return 0;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DifferentWaystoAddParentheses sln = new DifferentWaystoAddParentheses();
		List<Integer> res = sln.diffWaysToCompute("2*3-4*5");
		for(int i = 0; i < res.size(); i++){
			System.out.print(res.get(i)+" ");
		}
	}

}
