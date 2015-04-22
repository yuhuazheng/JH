package Algorithms;

public class NumberOfIslands {

	public static void main(String[] args){
		char[][] grid = {
				{'1','1','1'},
				{'0','1','0'},
				{'1','1','1'},
				};
		NumberOfIslands inst = new NumberOfIslands();
		System.out.println(inst.numIslands(grid));
	}
	
	public int numIslands(char[][] grid) {
		if(grid==null|| grid.length<1 || grid[0].length<1){
			return 0;
		}
		int m=grid.length;
		int n=grid[0].length;
		boolean[][] visited = new boolean[m][n];
		int count=0;
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(grid[i][j]=='1' && !visited[i][j]){
					count++;
				}
				floodfill(i,j,grid,visited);
			}
		}
		return count;
	}
	
	private void floodfill(int i, int j, char[][] grid, boolean[][] visited){
		int m=grid.length;
		int n=grid[0].length;
		if(i<0 || j<0 || i>=m || j>=n){
			return;
		}
		if(visited[i][j]){
			return;
		}
		visited[i][j]=true;
		if(grid[i][j]=='0'){
			return;
		}
		floodfill(i-1,j,grid,visited);
		floodfill(i+1,j,grid,visited);
		floodfill(i,j-1,grid,visited);
		floodfill(i,j+1,grid,visited);
		return;
	}
}
