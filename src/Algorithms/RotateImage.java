package myPractice;

public class RotateImage {

	public static void main(String[] args){
		int[][] matrix = { {1,2,3},{4,5,6},{7,8,9}};
		RotateImage helper = new RotateImage();
		helper.rotate(matrix);
	}
	
	public void rotate(int[][] matrix) {
		if(matrix==null || matrix.length<1 || matrix[0].length<1 || matrix.length!=matrix[0].length){
			return;
		}
		
		// (i,j) -> (j,n-1-i) -> (n-1-i,n-1-j) -> (n-1-j,i) -> (i,j)
		int n=matrix.length;
		int m=matrix.length/2;
		for(int i=0;i<m;i++){
			for(int j=i;j<n-1-i;j++){
				int temp = matrix[i][j];
				matrix[i][j]= matrix[n-1-j][i];
				matrix[n-1-j][i]= matrix[n-1-i][n-1-j];
				matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
				matrix[j][n-1-i]=temp;
			}
		}
	}
}
