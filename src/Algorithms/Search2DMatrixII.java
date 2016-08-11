
import java.util.ArrayList;

/**
 * Created by yuhuazh on 10/7/2015.
 */
public class Search2DMatrixII {

    public static void main(String[] args){
        int[][] matrix = {
                {-1,  3}
        };
        Search2DMatrixII inst = new Search2DMatrixII();
        System.out.println(inst.searchMatrix(matrix,3));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0||matrix[0].length==0) return false;
        if(matrix.length==1&&matrix[0].length==1) return matrix[0][0]==target;
        int m = matrix.length;
        int n = matrix[0].length;
        return dnc(0,m-1,0,n-1,matrix,target);
    }

    private boolean dnc(int top, int botm, int l, int r, int[][] matrix, int target){
        if(top>botm||l>r) return false;

        int midrow=(top+botm)/2;
        int midcol=(l+r)/2;
        int v = matrix[midrow][midcol];

        if(v==target)
            return true;
        else if(v>target){
            return (dnc(top,midrow-1,l,midcol-1,matrix,target)
                    ||dnc(top,midrow-1,midcol,r,matrix,target)
                    ||dnc(midrow,botm,l,midcol-1,matrix,target)
            );
        }
        else{
            return (dnc(midrow+1,botm,midcol+1,r,matrix,target)
                    ||dnc(top,midrow,midcol+1,r,matrix,target)
                    ||dnc(midrow+1,botm,l,midcol,matrix,target)
            );
        }
    }
}
