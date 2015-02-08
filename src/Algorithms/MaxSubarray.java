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
		
		Boolean allNeg = true;
		int maxneg=A[0];
		int maxsub=A[0];
		int cursub=A[0];
		
		for(int i=1; i<A.length;i++){
			if(A[i]<0 && A[i]>maxneg){
				maxneg=A[i];
			}
			if(allNeg && A[i]>=0){
				allNeg = false;
			}
			
			if(cursub<0){
				//restart sub
				cursub=A[i];
			}
			else{
				cursub+=A[i];
			}
			
			if(cursub>maxsub){
				maxsub=cursub;
			}
		}
		
		if(!allNeg){
			return maxsub;
		}
		else{
			return maxneg;
		}
	}
        
}
