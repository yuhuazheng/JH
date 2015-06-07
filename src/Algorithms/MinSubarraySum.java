package Algorithms;

public class MinSubarraySum {

	public static void main(String[] args){
		int[] nums = {1,2,3,4,5};
		MinSubarraySum inst = new MinSubarraySum();
		System.out.println(inst.minSubArrayLen(11, nums));
	}
	
	public int minSubArrayLen(int s, int[] nums) {
		if(nums==null||nums.length==0) return 0;
		int left=0;
		int right=0;
		int cur = nums[0];
		if(cur>=s) return 1;
		int minlen = 0;
		
		for(int i=1;i<nums.length;i++){
			if(nums[i]>=s) return 1;
			right=i;
			cur+=nums[i];
			while(cur>=s && left<right){
				int templen=right-left+1;
				if(minlen==0 || (minlen!=0 && templen<minlen)){
					minlen=templen;
				}
				cur-=nums[left];
				left++;
			}
		}
		return minlen;
	}
}
