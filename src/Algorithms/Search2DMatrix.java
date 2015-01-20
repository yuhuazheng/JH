package myPractice;

import java.util.Arrays;

public class Search2DMatrix {

	public static void main(String[] args){
		int[][] matrix = {
				{1,3,5,7},
				{10,11,16,20},
				{23,30,34,50},
				{60,61,62,63},
				{60,61,62,63},
				{60,61,62,63}
		};
		int target =50;
		Search2DMatrix helper = new Search2DMatrix();
		System.out.println(helper.searchMatrix(matrix,target));
	}
	
	public boolean searchMatrix(int[][] matrix,int target){
		
		if(matrix == null || matrix.length==0 || matrix[0].length==0)
	        return false;
	    int l = 0;
	    int r = matrix.length-1;
	    while(l<=r)
	    {
	        int mid = (l+r)/2;
	        if(matrix[mid][0] == target) return true;
	        if(matrix[mid][0] > target)
	        {
	            r = mid-1;
	        }
	        else
	        {
	            l = mid+1;
	            //here you might wonder what if the target is at matrix[mid][somewhere];
	            //l=mid+1 seems missing the right row.
	            //however matrix[mid][0]>target will always true; to bring r->l till l=r=mid
	            //then r=mid-1 will be the right row.
	        }
	    }
	    int row = r;
	    if(row<0)
	        return false;
	    l = 0;
	    r = matrix[0].length-1;
	    while(l<=r)
	    {
	        int mid = (l+r)/2;
	        if(matrix[row][mid] == target) return true;
	        if(matrix[row][mid] > target)
	        {
	            r = mid-1;
	        }
	        else
	        {
	            l = mid+1;
	        }
	    }   
	    return false;
		
		/*if(matrix==null || matrix.length<1 || matrix[0].length<1){
			return false;
		}
		
		int m=matrix.length;
		int n=matrix[0].length;
		
		//find row
		int rowU=0;
		int rowB=matrix.length-1;
		boolean foundRow = false;
		int rowIdx=0;
		
		while(!foundRow && rowU<=rowB){
			int rowM=(rowU+rowB)/2;
			if(target>=matrix[rowB][0]){
				foundRow=true;
				rowIdx=rowB;
				break;
			}
			if(target<=matrix[rowU][n-1]){
				foundRow=true;
				rowIdx=rowU;
				break;
			}
			if(target<matrix[rowM][0]){
				rowB=rowM-1;
			}
			else if(target>matrix[rowM][n-1]){
				rowU=rowM+1;
			}
			else{
				foundRow=true;
				rowIdx=rowM;
				break;
			}
		}
		if(!foundRow){
			return false;
		}
		
		//find in column
		if(Arrays.binarySearch(matrix[rowIdx], target)>=0){
			return true;
		}
		return false;*/
	}
}
