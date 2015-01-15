package myPractice;

public class ContainMostWater {

	public static void main(String[] args){
		int[] height = new int[3];
		ContainMostWater helper = new ContainMostWater();
		System.out.println(helper.maxArea(height));
	}
	
	public int maxArea(int[] height){
		if(height==null || height.length<2){
			return 0;
		}
		if(height.length==2){
			return Math.min(height[0], height[1]);
		}
		
		int left=0;
		int right=height.length-1;
		int max=Math.min(height[left],height[right])*(right-left);
		while(left<right){
			int cur = Math.min(height[left],height[right])*(right-left);
			if(cur>max){
				max=cur;
			}
			if(height[left]<=height[right]){
				left++;
			}
			else{
				right--;
			}
		}
		return max;
	}
}
