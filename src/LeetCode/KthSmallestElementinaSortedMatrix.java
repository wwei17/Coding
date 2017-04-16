package LeetCode;

import java.util.PriorityQueue;

public class KthSmallestElementinaSortedMatrix {

    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Cell> pq = new PriorityQueue<Cell>();
        for(int i = 0 ; i < matrix.length; i++){
            pq.offer(new Cell(matrix[i][0],i,0));
        }
        Cell temp = null;
        for(int i = 0 ; i < k-1; i++){
            temp = pq.poll();
            if(temp.col < matrix[temp.row].length -1){
                pq.offer(new Cell(matrix[temp.row][temp.col+1],temp.row, temp.col+1));
            }
        }
        return pq.poll().val;
    }
    
    class Cell implements Comparable<Cell>{
        int val;
        int col;
        int row;
        Cell(int val, int row, int col){
            this.val = val;
            this.col = col;
            this.row = row;
        }
        
        @Override
        public int compareTo(Cell c){
            return this.val-c.val;
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KthSmallestElementinaSortedMatrix sln = new KthSmallestElementinaSortedMatrix();
		System.out.println(sln.kthSmallest(new int[][]{{1,3,5},{6,7,12},{11,14,14}}, 3));
	}

}
