package LeetCode;

import java.util.HashMap;

public class FractiontoRecurringDecimal {

    public String fractionToDecimal(int numerator, int denominator) {
        HashMap<Long,Integer> map = new HashMap<Long,Integer>();
        String sign = (long)numerator*(long)denominator>=0? "": "-";
        long n = numerator >= 0? numerator : -1*(long)numerator;
        long d = denominator >= 0? denominator : -1*(long)denominator;
        long n1 = n/d;
        long c1 = n%d;
        
        StringBuffer sb = new StringBuffer("");
        
        for(int i = 0 ; c1 != 0; i++){
            c1 = c1*10;
            if(map.containsKey(c1)){
                sb.insert(map.get(c1),"(");
                sb.append(")");
                sb.insert(0,sign+n1+".");
                return sb.toString();
            }else{
                map.put(c1,i);
            }
            sb.append(c1/d);
            c1 = c1%d;
        }
        if(sb.length()!=0){
            sb.insert(0, sign+n1+".");
            return sb.toString();
        }else{
            return sign+n1;
        }
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
