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
        if(matrix==null ||matrix.length==0||matrix[0].length==0) return false;
        int row = matrix.length;
        int col = matrix[0].length;

        int r=0;
        int c=col-1;
        //from top-right, shrink
        while(r<row&&c>=0){
            int x = matrix[r][c];
            if(x==target) return true;
            if(x>target) c--; //this col is not valid
            else r++; //this row is not valid
        }
        return false;

    }
}
