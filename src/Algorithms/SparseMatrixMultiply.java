package Algorithms;

import java.util.Arrays;

/**
 * Created by yuhua on 1/1/16.
 */
public class SparseMatrixMultiply {
    public static void main(String[] args) {
        SparseMatrixMultiply inst = new SparseMatrixMultiply();
        int[][] A = {
                {1,0,0},
                {-1,0,3}
        };
        int[][] B = {
                {7,0,0},
                {0,0,0},
                {0,0,1}
        };
        int[][] C = inst.multiply(A,B);
        for(int[] row : C){
            System.out.println(Arrays.toString(row));
        }
    }

    public int[][] multiply(int[][] A, int[][] B) {
        int m=A.length;
        int n=A[0].length;
        int l=B[0].length;
        int[][] res = new int[m][l];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(A[i][j]==0) continue;
                for(int k=0;k<l;k++){
                    res[i][k]+=A[i][j]*B[j][k];
                }
            }
        }
        return res;
    }
}
