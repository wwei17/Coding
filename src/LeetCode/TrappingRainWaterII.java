package LeetCode;

import java.util.PriorityQueue;

public class TrappingRainWaterII {

    public int trapRainWater(int[][] heightMap) {
        if(heightMap == null || heightMap.length < 3 || heightMap[0].length < 3) return 0;
        
        Cell[][] cells = new Cell[heightMap.length][heightMap[0].length];
        for(int i = 0; i <heightMap.length; i++){
            for(int j = 0; j < heightMap[i].length; j++){
                cells[i][j] = new Cell(heightMap[i][j], i, j);
            }
        }
        PriorityQueue<Cell> q = new PriorityQueue<Cell>();
        for(int i = 0; i < heightMap.length; i++){
            q.offer(cells[i][0]); cells[i][0].visited = true;
            q.offer(cells[i][heightMap[i].length-1]); cells[i][heightMap[i].length-1].visited = true;
        }
        for(int i = 0; i < heightMap[0].length; i++){
            q.offer(cells[0][i]); cells[0][i].visited = true;
            q.offer(cells[heightMap.length-1][i]); cells[heightMap.length-1][i].visited = true;
        }
        
        int sum = 0;
        Cell tempCell = null;
        Cell tempCell2 = null;
        while(q.size()>0){
            tempCell = q.poll();
            tempCell.visited = true;
            if(tempCell.col > 0 && !cells[tempCell.row][tempCell.col-1].visited){
                tempCell2 = cells[tempCell.row][tempCell.col-1];
                if(tempCell2.height < tempCell.height){
                    sum += (tempCell.height - tempCell2.height);
                    tempCell2.height = tempCell.height;
                }
                tempCell2.visited = true;
                q.offer(tempCell2);
            }
            if(tempCell.col < cells[tempCell.row].length-1 && !cells[tempCell.row][tempCell.col+1].visited){
                tempCell2 = cells[tempCell.row][tempCell.col+1];
                if(tempCell2.height < tempCell.height){
                    sum += (tempCell.height - tempCell2.height);
                    tempCell2.height = tempCell.height;
                }
                tempCell2.visited = true;
                q.offer(tempCell2);
            }
            if(tempCell.row > 0 && !cells[tempCell.row-1][tempCell.col].visited){
                tempCell2 = cells[tempCell.row-1][tempCell.col];
                if(tempCell2.height < tempCell.height){
                    sum += (tempCell.height - tempCell2.height);
                    tempCell2.height = tempCell.height;
                }
                tempCell2.visited = true;
                q.offer(tempCell2);
            }
            if(tempCell.row < cells.length-1 && !cells[tempCell.row+1][tempCell.col].visited){
                tempCell2 = cells[tempCell.row+1][tempCell.col];
                if(tempCell2.height < tempCell.height){
                    sum += (tempCell.height - tempCell2.height);
                    tempCell2.height = tempCell.height;
                }
                tempCell2.visited = true;
                q.offer(tempCell2);
            }
        }
        return sum;
        
    }
    
    class Cell implements Comparable<Cell>{
        int height;
        int row;
        int col;
        boolean visited;
        public Cell(int h, int r, int c){
            height = h;
            row = r;
            col = c;
            visited = false;
        }
        
        public int compareTo(Cell c){
            return this.height - c.height;
        }

    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] map = {
		               {1,4,3,1,3,2},
		               {3,2,1,3,2,4},
		               {2,3,3,2,3,1}
		};
		TrappingRainWaterII sln = new TrappingRainWaterII();
		System.out.println(sln.trapRainWater(map));

	}

}
