package Algorithms;

public class RotateArray {

	public static void main(String[] args){
		int[] nums = {1};
		RotateArray helper = new RotateArray();
		helper.rotate(nums, 0);
	}
	
	public void rotate(int[] nums, int k) {
		if(nums==null||nums.length<1 || k<0){
			return;
		}
		int c=k%nums.length;
		rev(nums,0,nums.length-1);
		rev(nums,0,c-1);
		rev(nums,c,nums.length-1);
		return;
	}
	private void rev(int[] nums, int l, int r){
		if(l>r){
			return;
		}
		int temp=0;
		while(l<=r){
			temp=nums[l];
			nums[l]=nums[r];
			nums[r]=temp;
			l++;
			r--;
		}
		return;
	}
}
