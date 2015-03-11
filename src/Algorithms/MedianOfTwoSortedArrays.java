package Algorithms;

public class MedianOfTwoSortedArrays {

	public double findMedianSortedArrays(int A[], int B[]) {
		if((A==null || A.length<1) && (B==null || B.length<1) ){
			return 0;
		}
		if(A==null || A.length<1){
			if(B.length%2==1){
				return (double)B[B.length/2];
			}
			else{
				return ((double)(B[B.length/2]+B[B.length/2-1])/2);
			}
		}
		if(B==null || B.length<1){
			if(A.length%2==1){
				return (double)A[A.length/2];
			}
			else{
				return ((double)(A[A.length/2]+A[A.length/2-1])/2);
			}
		}
		
		if((A.length+B.length)%2==1){
			return findKth(A,B,0,A.length-1,0,B.length-1,(A.length+B.length)/2+1);
		}
		else{
			return ( findKth(A,B,0,A.length-1,0,B.length-1,(A.length+B.length)/2)
					+ findKth(A,B,0,A.length-1,0,B.length-1,(A.length+B.length)/2+1))/2.0;
		}
	}
	
	private int findKth(int[] A, int[] B, int i, int i2, int j, int j2, int k){
		int m=i2-i+1;
		int n=j2-j+1;
		if(m>n){
			return findKth(B,A,j,j2,i,i2,k); //always m<=n
		}
		if(m==0){
			return B[j+k-1];
		}
		if(k==1){//reduce k til 1, get the minimal from current m,n
			return Math.min(A[i],B[j]);
		}
		
		int posA = Math.min(k/2, m);
		int posB = k-posA;
		if(A[i+posA-1]==B[j+posB-1]){
			return A[i+posA-1];
		}
		else if(A[i+posA-1]<B[j+posB-1]){
			return findKth(A,B,i+posA,i2,j,j+posB-1,k-posA);
		}
		else{
			return findKth(A,B,i,i+posA-1,j+posB,j2,k-posB);
		}
	}
}
