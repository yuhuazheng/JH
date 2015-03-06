package myPractice;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	public static void main(String[] args){
		int[][] matrix = { {2,5,8},{4,0,-1}};
		SpiralMatrix helper = new SpiralMatrix();
		helper.spiralOrder(matrix);
	}
	
	public List<Integer> spiralOrder(int[][] matrix) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if(matrix==null || matrix.length<1 || matrix[0].length<1){
			return res;
		}
		int m=matrix.length;
		int n=matrix[0].length;
		int layer = Math.min(m, n)/2;
		for(int i=0;i<layer;i++){
			//get top row
			for(int j=i;j<=n-1-i;j++){
				res.add(matrix[i][j]);
			}
			//get right column
			for(int j=i+1;j<=m-1-i;j++){
				res.add(matrix[j][n-1-i]);
			}
			//get bottom row
			for(int j=n-2-i;j>=i;j--){
				res.add(matrix[m-1-i][j]);
			}
			//get left column
			for(int j=m-2-i;j>i;j--){
				res.add(matrix[j][i]);
			}
		}
		//the middle row/col
		if(Math.min(m, n)%2==1){
			if(m>n){
				for(int j=layer;j<m-layer;j++){
					res.add(matrix[j][layer]);
				}
			}
			else{
				for(int j=layer;j<n-layer;j++){
					res.add(matrix[layer][j]);
				}
			}
		}
		return res;
	}
}
