package myPractice;

public class MergeSortedArray {

	public static void main(String[] args){
		int m=0;
		int n=0;
		int[] A = new int[m];
		int[] B = new int[n];
		
		MergeSortedArray helper = new MergeSortedArray();
		helper.merge(A,m,B,n);
		System.out.println(A);
	}
	
	public void merge(int A[], int m, int B[], int n){
		if(m<0 || n<0 || A==null || B==null ){
			return;
		}
		
		int idxA=m-1 ;
		int idxB=n-1;
		int idxM=m+n-1;
		while(idxA>=0 && idxB>=0){
			if(A[idxA]<=B[idxB]){
				A[idxM]=B[idxB];
				idxB--;
				idxM--;
			}
			else{
				A[idxM]=A[idxA];
				idxA--;
				idxM--;
			}
		}
		while(idxB>=0){
			A[idxM]=B[idxB];
			idxB--;
			idxM--;
		}
		return;
	}
}
