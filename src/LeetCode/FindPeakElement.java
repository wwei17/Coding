package LeetCode;

public class FindPeakElement {
    public int findPeakElement(int[] num) {
        if(num.length == 0) return -1;
        int start = 0;
        int end = num.length-1;
        int slope_s = 0;
        int slope_e = 0;
        
        while(end - start > 1){
            slope_s = num[start+1] - num[start];
            slope_e = num[end] - num[end-1];
            if(slope_s <0){ 
                return start;
            }else if(slope_e >0) {
                return end;
            }else{
                int mid = (start+end)/2;
                int slope_m = num[mid+1] - num[mid];
                if(slope_m>0){
                    start = mid;
                }else{
                    end = mid;
                }
            }
        }
        return num[start] > num[end] ? start: end;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
