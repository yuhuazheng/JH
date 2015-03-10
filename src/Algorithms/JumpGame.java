package Algorithms;

public class JumpGame {

	public boolean canJump(int[] A) {
		if(A==null || A.length<2){
			return true;
		}
		int global=A[0];
		int local=A[0];
		for(int i=1;i<=A.length-1&&i<=global;i++){
			local=i+A[i];
			global=Math.max(local, global);
			if(global>=A.length-1){
				return true;
			}
		}
		return false;
	}
}
