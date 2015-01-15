package myPractice;

import java.util.Arrays;

public class SetMatrixZeroes {

	public static void main(String[] args){
		int[][] matrix = new int[3][3];
		SetMatrixZeroes helper = new SetMatrixZeroes();
		helper.setZeroes(matrix);
	}
	
	public void setZeroes(int[][] matrix){
		//0:should set to 0; others: not set
		if(matrix==null || matrix.length<1 || matrix[0].length<1){
			return;
		}
		int r1=1;
		int c1=1;
		int m=matrix.length;
		int n=matrix[0].length;
		
		//mark row1 and col1
		for(int j=0; j<n; j++){
			if(matrix[0][j]==0){
				r1=0;
				break;
			}
		}
		for(int i=0; i<m; i++){
			if(matrix[i][0]==0){
				c1=0;
				break;
			}
		}
		
		//mark other rows and cols
		for(int i=1; i<m; i++){
			for(int j=1; j<n; j++){
				if(matrix[i][j]==0){
					matrix[i][0]=0;
					matrix[0][j]=0;
				}
			}
		}
		
		//write other rows and cols
		for(int i=1; i<m; i++){
			for(int j=1; j<n; j++){
				if(matrix[i][0]==0 || matrix[0][j]==0){
					matrix[i][j]=0;
				}
			}
		}
		
		//write row1
		if(r1==0){
			for(int j=0; j<n; j++){
				matrix[0][j]=0;
			}
		}
		
		//write c1
		if(c1==0){
			for(int i=0; i<m; i++){
				matrix[i][0]=0;
			}
		}
		
		return;
	}
}
