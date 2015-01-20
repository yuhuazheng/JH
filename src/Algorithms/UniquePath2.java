package myPractice;

import java.util.Arrays;

public class UniquePath2 {

	public static void main(String[] args){
		UniquePath2 helper = new UniquePath2();
		int[][] obstacleGrid = {
				{1},
				{0}
		};
		System.out.println(helper.uniquePathsWithObstacles(obstacleGrid));
	}
	
	public int uniquePathsWithObstacles(int[][] obstacleGrid){
		if(obstacleGrid==null || obstacleGrid.length<1 || obstacleGrid[0].length<1){
			return 0;
		}
		
		int m=obstacleGrid.length;
		int n=obstacleGrid[0].length;
		
		int[] buffer = new int[n];
		boolean flag=false;
		for(int j=0;j<n;j++){
			if(obstacleGrid[0][j]>0){
				flag=true;
				buffer[j]=0;
			}
			if(flag){
				buffer[j]=0;
			}
			else{
				buffer[j]=1;
			}
		}
		
		for(int i=1;i<=m-1;i++){
			if(obstacleGrid[i][0]>0){
				buffer[0]=0;
			}
			for(int j=1;j<n;j++){
				if(obstacleGrid[i][j]>0){
					buffer[j]=0;
				}
				else{
					buffer[j]=buffer[j-1]+buffer[j];
				}
			}
		}
		return buffer[n-1];
	}
}
