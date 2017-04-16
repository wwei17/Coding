package LeetCode;

public class RangeSumQuery2DImmutable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class NumMatrix {
    
    int[][] sums = null;

    public NumMatrix(int[][] matrix) {
        
        sums = new int[matrix.length][];
        for(int i = 0; i< matrix.length; i++){
            sums[i] = new int[matrix[i].length];
            for(int j = 0; j < matrix[i].length; j++){
                if(i == 0){
                    if(j == 0){
                        sums[i][j] = matrix[i][j];
                    }else{
                        sums[i][j] = sums[i][j-1] + matrix[i][j];
                    }
                }else{
                    if(j == 0){
                        sums[i][j] = sums[i-1][j] + matrix[i][j];
                    }else{
                        sums[i][j] = sums[i-1][j] + sums[i][j-1] - sums[i-1][j-1] + matrix[i][j];
                    }
                }
            }
        }
    }


    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(row1 == 0){
            if(col1 == 0){
                return sums[row2][col2];
            }else{
                return sums[row2][col2]-sums[row2][col1-1];
            }
        }else{
            if(col1 == 0){
                return sums[row2][col2]-sums[row1 -1][col2];
            }else{
                return sums[row2][col2]-sums[row1 -1][col2] -sums[row2][col1-1] + sums[row1 -1][col1-1];
            }
        }
    }

}
