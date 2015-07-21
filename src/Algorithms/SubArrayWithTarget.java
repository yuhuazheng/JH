package Algorithms;

public class SubArrayWithTarget {

	public static void main(String[] args){
		int[] nums = {2,4,8};
		int target = 10;
		System.out.println(findSub(nums,target));
	}
	
	public static boolean findSub(int[] nums, int target){
		if(nums==null||nums.length==0) return false;
		int cur=0;
		int left=0;
		for(int i=0;i<nums.length;i++){
			cur+=nums[i];
			while(cur>target&&left<nums.length){
				cur-=nums[left];
				left++;
			}
			if(cur==target) return true;
		}
		return false;
	}
}
