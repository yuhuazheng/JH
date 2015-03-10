package Algorithms;

public class JumpGame2 {

	public int jump(int[] A) {
		if(A==null){
			return 0;
		}
		if(A.length<2){
			return 0;
		}
		int step=1;
		int lastGlobal=0; //Farthest distance without adding one more step
		int global=A[0];
		int local=A[0];
		for(int i=1;i<=A.length-1&&i<=global;i++){
			if(global>=A.length-1){
				return step;
			}
			if(i>lastGlobal){
				step++;
				lastGlobal=global;
			}
			
			local=i+A[i];
			global=Math.max(local, global);
		}
		return 0;
	}
}
