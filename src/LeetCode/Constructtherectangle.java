package LeetCode;

public class Constructtherectangle {

    public int[] constructRectangle(int area) {
        int c1 = (int)(Math.sqrt(area));
        for(int i = c1; i>0; i--){
            if(area%i ==0){
                return new int[]{area/i, i};
            }
        }
        return null;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
