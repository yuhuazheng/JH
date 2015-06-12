package Algorithms;

public class MaxSquare {

	public static void main(String[] args){
		char[][] matrix = {
				{'1','1','1','1','1','1','1','1'},
				{'1','1','1','1','1','1','1','0'},
				{'1','1','1','1','1','1','1','0'},
				{'1','1','1','1','1','0','0','0'},
				{'0','1','1','1','1','0','0','0'}
		};
		
		MaxSquare inst = new MaxSquare();
		System.out.println(inst.maximalSquare(matrix));
	}
	
	public int maximalSquare(char[][] matrix) {
		if(matrix==null||matrix.length==0||matrix[0].length==0) return 0;
		int row=matrix.length;
		int col=matrix[0].length;
		int[][] res = new int[row][col];
		int max=0;
		
		//first row
		for(int i=0;i<col;i++){
			if(matrix[0][i]=='1') {
				res[0][i]=1;
				max=1;
			}
		}
		//first col
		for(int i=0;i<row;i++){
			if(matrix[i][0]=='1'){
				res[i][0]=1;
				max=1;
			}
		}
		
		//dp for the rest
		for(int i=1;i<row;i++){
			for(int j=1;j<col;j++){
				if(matrix[i][j]=='1'){
					if(res[i-1][j-1]>0 && res[i-1][j]>0 && res[i][j-1]>0){
						int temp1 = (int) Math.sqrt(res[i-1][j-1]);
						int temp2 = (int) Math.sqrt(res[i-1][j]);
						int temp3 = (int) Math.sqrt(res[i][j-1]);
						int len = Math.min(temp1, Math.min(temp2, temp3));
						res[i][j] = (len+1)*(len+1);
						if(res[i][j]>max) max=res[i][j];
					}
					else{
						res[i][j]=1;
					}
				}
			}
		}
		
		return max;
	}
}
