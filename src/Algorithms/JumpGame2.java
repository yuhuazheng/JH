
public class JumpGame2 {

	public int jump(int[] nums) {
		if(nums==null||nums.length<2) return 0;

		int n=nums.length;
		int curMax=nums[0];
		int step=1;
		int i=1;
		int ntMax=curMax;
		if(curMax>=n-1) return 1;

		while(i<=curMax){
			ntMax=Math.max(ntMax,i+nums[i]);
			if(i==curMax){
				step++;
				curMax=ntMax;
				if(curMax>=n-1)
					return step;
			}
			i++;
		}
		return -1;
	}
}
