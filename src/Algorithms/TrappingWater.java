package Algorithms;

public class TrappingWater {

	public int trap(int[] height) {
		if(height==null||height.length<3) return 0;
		int res=0;
		int max=0;
		int[] buffer = new int[height.length];
		
		//if you stand at i point, look up to both left and right, the distance between yourself and the lowest higher bar
		//is the water you can hold.
		
		//scan from left
		for(int i=0;i<height.length;i++){
			buffer[i]=max;
			max=Math.max(max, height[i]);
		}
		
		max=0;
		//scan from right
		for(int i=height.length-1;i>=0;i--){
			buffer[i]=Math.min(max, buffer[i]);
			max=Math.max(max, height[i]);
			res+=buffer[i]-height[i]>0?buffer[i]-height[i]:0;
		}
		
		return res;
	}
}
