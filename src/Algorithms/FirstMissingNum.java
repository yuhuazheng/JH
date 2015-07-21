package Algorithms;

public class FirstMissingNum {

	public static void main(String[] args){
		int[] nums = {1,2,3};
		System.out.println(FindFirstMissingNum(nums));
	}
	
	public static int FindFirstMissingNum(int[] nums){
		if(nums==null||nums.length==0) return -1;
		
		if(nums[nums.length-1]==nums.length-1)
			return nums.length;
		int l=0;
		int r=nums.length-1;
		while(l<=r){
			int m=(l+r)/2;
			if(nums[m]==m){
				l=m+1;
			}
			else{
				if(m==0||nums[m-1]==m-1)
					return m;
				r=m-1;
			}
		}
		return -1;
	}
}
