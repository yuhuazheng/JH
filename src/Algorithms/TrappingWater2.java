package Algorithms;

public class TrappingWater2 {

	public int trap(int[] height) {
		if(height==null||height.length<3) return 0;
		int l=0;
		int r=height.length-1;
		int res=0;
		while(l<r){
			int min=Math.min(height[l], height[r]);
			if(height[l]==min){
				l++;
				while(l<r&&height[l]<min){
					res+=min-height[l];
					l++;
				}
			}
			else{
				r--;
				while(l<r&&height[r]<min){
					res+=min-height[r];
					r--;
				}
			}
		}
		return res;
	}
}
