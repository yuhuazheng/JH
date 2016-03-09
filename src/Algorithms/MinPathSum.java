package myPractice;

public class MinPathSum {

	public static void main(String[] args){
		int[][] grid = {{0,2,2,6,4,1,6,2,9,9,5,8,4,4},
				{0,3,6,4,5,5,9,7,8,3,9,9,5,4},
				{6,9,0,7,2,2,5,6,3,1,0,4,2,5},
				{3,8,2,3,2,8,8,7,5,9,6,3,4,5},
				{4,0,1,3,9,2,0,1,6,7,9,2,8,9},
				{6,2,7,9,0,9,5,2,7,5,1,4,4,7},
				{9,8,3,3,0,6,8,0,8,8,3,5,7,3},
				{7,7,4,5,9,1,5,0,2,2,2,1,7,4},
				{5,1,3,4,1,6,0,4,3,8,4,3,9,9},
				{0,6,4,9,4,1,5,5,4,2,5,7,4,0},
				{0,1,6,6,4,9,2,7,8,2,1,3,3,7},
				{8,4,9,9,2,3,8,6,6,5,4,1,7,9}};
		MinPathSum helper = new MinPathSum();
		System.out.println(helper.minPathSum(grid));
	}
	
	public int minPathSum(int[][] grid){
		if(grid==null||grid.length==0||grid[0].length==0) return 0;
		int row=grid.length;
		int col=grid[0].length;
		int[][] res = new int[row][col];
		res[0][0]=grid[0][0]; //initialization

		//first row
		for(int c=1;c<col;c++){
			res[0][c]=res[0][c-1]+grid[0][c];
		}
		//fist column
		for(int r=1;r<row;r++){
			res[r][0]=res[r-1][0]+grid[r][0];
		}

		//propogate
		for(int r=1;r<row;r++){
			for(int c=1;c<col;c++){
				res[r][c]=Math.min(res[r-1][c],res[r][c-1])+grid[r][c];
			}
		}
		return res[row-1][col-1];
	}
}
