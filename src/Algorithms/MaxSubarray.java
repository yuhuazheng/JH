package Algorithms;

public class MaxSubarray {

	public static void main(String[] args){
		//int[] a= {-2,1,-3,4,-1,2,1,-5,4};
		int[] a= {1,-2,0};
		MaxSubarray helper = new MaxSubarray();
		System.out.println(helper.maxSubArray(a));
	}
	
	public int maxSubArray(int[] A) {
		if(A==null || A.length<1){
			return 0;
		}
		
		int global = A[0];
		int local = A[0];
		for(int i=1;i<A.length;i++){
			local = Math.max(A[i], local+A[i]);
			global = Math.max(global,local);
		}
		return global;
	}     
}
