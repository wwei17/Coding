package LeetCode;

public class FindMinimuminRotatedSortedArray {

    public int findMin(int[] num) {
        int start = 0;
        int end = num.length-1;
        int mid;
        boolean found = false;
        while(!found){
            if(start == end -1){
                return Math.min(num[start], num[end]);
            }
            mid = (start+end)/2;
            if(num[start] > num[mid]){
                end = mid;
            }else if(num[mid] > num[end]){
                start = mid;
            }else{
                return num[start];
            }
        }
        return 0;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
