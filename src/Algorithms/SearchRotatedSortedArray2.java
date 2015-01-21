package myPractice;

public class SearchRotatedSortedArray2 {

	public static void main(String[] args){
		int[] A = new int[3];
		int target = 1;
		SearchRotatedSortedArray2 helper = new SearchRotatedSortedArray2();
		System.out.println(helper.search(A,target));
	}
	
	public boolean search(int[] A, int target){
		
		if(A==null || A.length<1){
			return false;
		}
		
		int l=0;
		int r=A.length-1;
		while(l<=r){
			int m=(l+r)/2;
			if(A[m]==target) return true;
			if(A[m]>A[l]){
				if(target>=A[l]&&target<=A[m]){
					r=m-1;
				}
				else{
					l=m+1;
				}
			}
			else if(A[m]<A[l]){
				if(target>=A[m]&&target<=A[r]){
					l=m+1;
				}
				else{
					r=m-1;
				}
			}
			else{
				l=l+1;
			}
		}
		return false;
	}
}
