package myPractice;

import java.util.ArrayList;

public class SpiralMatrix2 {

	public static void main(String[] args){
		SpiralMatrix2 helper = new SpiralMatrix2();
		helper.generateMatrix(3);
	}
	
	public int[][] generateMatrix(int n) {
		int[][] matrix = {};
		if(n<=0){
			return matrix;
		}
		matrix = new int[n][n];
		if(n==1){
			matrix[0][0]=1;
			return matrix;
		}
		int value=1;
		int layer = n/2;
		for(int i=0;i<layer;i++){
			//get top row
			for(int j=i;j<=n-1-i;j++){
				matrix[i][j]=value++;
			}
			//get right column
			for(int j=i+1;j<=n-1-i;j++){
				matrix[j][n-1-i]=value++;
			}
			//get bottom row
			for(int j=n-2-i;j>=i;j--){
				matrix[n-1-i][j]=value++;
			}
			//get left column
			for(int j=n-2-i;j>i;j--){
				matrix[j][i]=value++;
			}
		}
		if(n%2==1){
			matrix[layer][layer]=value;
		}
		return matrix;
	}
}

