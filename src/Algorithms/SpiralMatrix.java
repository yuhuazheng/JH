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
		public List<Integer> spiralOrder(int[][] matrix) {
       ArrayList<Integer> res = new ArrayList<Integer>();
		if(matrix==null || matrix.length<1 || matrix[0].length<1){
			return res;
		}
		int m=matrix.length;
		int n=matrix[0].length;
		int row=0;
		int col=-1;
		while(true){
		    //top row
		    for(int i=0; i<n; i++){
		        res.add(matrix[row][++col]); //++at front because every turn will shrink one step first
		    }
		    if(--m==0) break; //no more vertical direction
		    //right column
		    for(int i=0; i<m; i++){
		        res.add(matrix[++row][col]);
		    }
		    if(--n==0) break;
		    //bottom row
		    for(int i=0; i<n; i++){
		        res.add(matrix[row][--col]);
		    }
		    if(--m==0) break;
		    //left column
		    for(int i=0; i<m; i++){
		        res.add(matrix[--row][col]);
		    }
		    if(--n==0) break;
		}
		return res;
	}
}
