package LeetCode;

public class FindMinimuminRotatedSortedArrayII {

    public int findMin(int[] num) {
        if(num.length == 1) return num[0];
        return findMin(num, 0, num.length -1);
    }
    
    public int findMin(int[] num, int start, int end){
        if(end - start == 1) return num[start] > num[end] ? num[end] : num[start];
        int mid = (start+end)/2;
        if(num[start] > num[mid]){
            return findMin(num, start, mid);
        }else if(num[mid] > num[end]){
            return findMin(num, mid, end);
        }else{
            return Math.min(findMin(num,start, mid),findMin(num,mid, end));
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
