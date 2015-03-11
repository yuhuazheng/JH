package Algorithms;

public class SearchInsertPosition {

	public int searchInsert(int[] A, int target) {
		if(A==null || A.length<1){
			return 0;
		}
		
		int l=0;
		int r=A.length-1;
		while(l<=r){
			int m=(l+r)/2;
			if(A[m]==target){
				return m;
			}
			if(A[m]<target){
				l=m+1;
			}
			else{
				r=m-1;
			}
		}
		return r+1;
	}
}
