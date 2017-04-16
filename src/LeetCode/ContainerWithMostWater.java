package LeetCode;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int i = 0; int j = height.length-1;
        int maxArea = Integer.MIN_VALUE;
        while(i<j){
            maxArea = Math.max(maxArea, (j-i)*Math.min(height[i],height[j]));
            if(height[i] > height[j]){
                j--;
            }else{
                i++;
            }
        }

        return maxArea;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
