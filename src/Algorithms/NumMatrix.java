package Algorithms;

/**
 * Created by yuhuazh on 4/12/2016.
 */
public class NumMatrix {

    int[][] sumMatrix;

    public NumMatrix(int[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0) return;
        sumMatrix = new int[matrix.length][matrix[0].length];

        for(int i=0;i<matrix.length;i++){
            int rowSum=0;
            for(int j=0;j<matrix[0].length;j++){
                rowSum+=matrix[i][j];
                if(i==0)
                    sumMatrix[i][j]=rowSum;
                else
                    sumMatrix[i][j]=rowSum+sumMatrix[i-1][j];
            }
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = sumMatrix[row2][col2];
        if(row1>0&&col1>0)
            sum+=sumMatrix[row1-1][col1-1];
        if(col1>0)
            sum-=sumMatrix[row2][col1-1];
        if(row1>0)
            sum-=sumMatrix[row1-1][col2];
        return sum;
    }

    public static void main(String[] args) {
        int[][] matrix = {{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}};
        NumMatrix inst = new NumMatrix(matrix);
        System.out.println(inst.sumRegion(2,1,4,3));
    }
}
