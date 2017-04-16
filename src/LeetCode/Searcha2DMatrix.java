package LeetCode;

public class Searcha2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int start=0;
        int end = matrix.length-1;
        int mid = (start+end)>> 1;
        while(start + 1 < end){
            mid = (start+end)>> 1;
            if(matrix[mid][0] == target){
                return true;
            }else if(matrix[mid][0] > target){
                end = mid-1;
            }else{
                start = mid;
            }
        }
        if(matrix[start][0] == target || matrix[end][0] == target){
            return true;
        }else if(matrix[start][0] > target){
            return false;
        }else if(matrix[end][0] < target){
            mid = end;
        }else{
            mid = start;
        }
        
        int start2 = 0;
        int end2 = matrix[mid].length-1;
        int mid2 =  (start2+end2)>> 1;
        while(start2 + 1 < end2){
            mid2 = (start2+end2)>> 1;
            if(matrix[mid][mid2] == target){
                return true;
            }else if(matrix[mid][mid2] > target){
                end2 = mid2-1;
            }else{
                start2 = mid2;
            }
        }
        
        if(matrix[mid][start2] == target || matrix[mid][end2] == target){
            return true;
        }else{
            return false;
        }

    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
