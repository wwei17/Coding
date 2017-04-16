package LeetCode;

public class Candy {

    public int candy(int[] ratings) {
        int [] candies = new int[ratings.length];
        int a = 1;
        int sum = 0;
        for(int i = 0; i<ratings.length; i++){
            if(i != 0){
                if(ratings[i-1] < ratings[i]){
                    a++;
                }else{
                    a = 1;
                    candies[i] = a;
                    int j = i;
                    while(j >0 && candies[j-1] <= candies[j] && ratings[j-1] > ratings[j]){
                        candies[j-1] ++;
                        j--;
                    }
                }
            }
            
            candies[i] = a;
        }
        
        for(int i = 0; i <candies.length; i++){
            sum += candies[i];
        }
        return sum;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
