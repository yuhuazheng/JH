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
		 /*if(grid == null || grid.length==0 || grid[0].length==0)
		        return 0;
		    int[] res = new int[grid[0].length];
		    res[0] = grid[0][0];
		    for(int i=1;i<grid[0].length;i++)
		    {
		        res[i] = res[i-1]+grid[0][i];
		    }
		    for(int i=1;i<grid.length;i++)
		    {
		        for(int j=0;j<grid[0].length;j++)
		        {
		            if(j==0)
		                res[j] += grid[i][j];
		            else
		                res[j] = Math.min(res[j-1], res[j])+grid[i][j];
		        }
		    }
		    return res[grid[0].length-1];*/
		
		if(grid==null || grid.length<1 || grid[0].length<1){
			return 0;
		}
		
		int m=grid.length;
		int n=grid[0].length;
		int[][] buffer=new int[m][n];
		
		int upCost=0;
		int leftCost=0;
		int curCost=0;
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(i-1>=0){
					upCost=buffer[i-1][j];
				}
				else{
					upCost=0;
				}
				
				if(j-1>=0){
					leftCost=buffer[i][j-1];
				}
				else{
					leftCost=0;
				}
				
				curCost=grid[i][j];
				if(i-1<0){
					buffer[i][j]=leftCost+curCost;
				}
				else if(j-1<0){
					buffer[i][j]=upCost+curCost;
				}
				else{
				buffer[i][j]=Math.min(upCost, leftCost)+curCost;
				}
			}
		}
/*		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				System.out.print(buffer[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}*/
		
		return buffer[m-1][n-1];
	}
}
