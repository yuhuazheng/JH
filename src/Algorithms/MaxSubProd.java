package Algorithms;

public class MaxSubProd {

	public static void main(String[] args){
		int[] A = {-2,3,-4};
		MaxSubProd helper = new MaxSubProd();
		System.out.println(helper.maxProduct(A));
	}
	
	public int maxProduct(int[] A) {
		if(A==null || A.length<1){
			return 0;
		}
		
		int local=A[0];
		int global=A[0];
		int localmin=A[0];
		for(int i=1; i<A.length;i++){
			int localcopy=local;
			local=Math.max(local*A[i], A[i]);
			local=Math.max(local, localmin*A[i]);
			localmin = Math.min(Math.min(A[i], localcopy*A[i]),localmin*A[i]);
			global=Math.max(global, local);
		}
		return global;
	}
        
}
