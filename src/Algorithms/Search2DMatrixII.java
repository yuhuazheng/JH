package Algorithms;

import java.util.ArrayList;

/**
 * Created by yuhuazh on 10/7/2015.
 */
public class Search2DMatrixII {

    public static void main(String[] args){
        int[][] matrix = {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        Search2DMatrixII inst = new Search2DMatrixII();
        System.out.println(inst.searchMatrix(matrix,5));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0) return false;
        if(target<matrix[0][0]) return false;
        int r=matrix.length;
        int c=matrix[0].length;
        if(target>matrix[r-1][c-1]) return false;

        //find possible rows
        //take all elements of 1st column, find the location to insert target
        int start=0;
        int end=r-1;
        while(start<=end){
            int m = (start+end)/2;
            if(matrix[m][0]==target) return true;
            if(matrix[m][0]>target){
                end=m-1;
            }
            else{
                start=m+1;
            }
        }
        int upperR=start-1;

        //now look at the last column
        end=start-1;
        start=0;
        while(start<=end){
            int m=(start+end)/2;
            if(matrix[m][c-1]==target) return true;
            if(matrix[m][c-1]>target){
                end=m-1;
            }
            else{
                start=m+1;
            }
        }
        int lowerR=start;

        if(lowerR>upperR) return false;

        //find col
        for(int i=lowerR;i<=upperR;i++) {
            start = 0;
            end = c - 1;
            while (start <= end) {
                int m = (start + end) / 2;
                if (matrix[i][m] == target) return true;
                if (matrix[i][m] < target) {
                    start = m + 1;
                } else {
                    end = m - 1;
                }
            }
        }
        return false;
    }
}
