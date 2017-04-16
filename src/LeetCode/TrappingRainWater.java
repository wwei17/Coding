package LeetCode;

public class TrappingRainWater {

    public int trap(int[] height) {
        if(height.length == 0) return 0;
        int i_l = 0;
        int i_r = height.length-1;
        int p_l = height[i_l];    //left peek;
        int p_r = height[height.length-1];  //right peek;
        int peek = Math.min(p_l, p_r);
        int sum = 0;
        boolean from_left = p_l < p_r;
        
        while(i_l < i_r){
            if(from_left){
                if(height[i_l] > p_l){
                    p_l = height[i_l];
                    peek = Math.min(p_l, p_r);
                }else{
                    sum+=peek-height[i_l];
                }
            }else{
                if(height[i_r] > p_r){
                    p_r = height[i_r];
                    peek = Math.min(p_l, p_r);
                }else{
                    sum+=peek-height[i_r];
                }
            }
            
            if(p_l < p_r){
                from_left = true;
                i_l++;
            }else{
                from_left = false;
                i_r--;
            }
        }
        return sum;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
