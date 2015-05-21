package Algorithms;

import java.util.Arrays;
import java.util.LinkedList;

public class LargestRectHist {

	public static void main(String[] args){
		int[] h = new int[30000];
		Arrays.fill(h, 1);
		LargestRectHist inst = new LargestRectHist();
		System.out.println(inst.largestRectangleArea(h));
	}
	
	public int largestRectangleArea(int[] height) {
		if(height==null||height.length==0) return 0;
        LinkedList<Integer> stk = new LinkedList<Integer>(); 
        int maxArea = 0;
        int i=0;
        while(i<height.length){
        	if(stk.isEmpty() || height[i]>=height[stk.peek()]){
        		stk.push(i);
        		i++;
        	}
        	else{
        		int h=height[stk.pop()];
        		int w = stk.isEmpty()? i : (i-stk.peek()-1);
        		maxArea = Math.max(maxArea, h*w);
        	}
        }
        //if the last element is not minimal, the stack can be non-empty. 
        //just now imagine adding a tail element with value 0, now i=height.length. and repeat above process
        while(!stk.isEmpty()){
        	int h = height[stk.pop()];
        	int w = stk.isEmpty()? height.length: (height.length-stk.peek()-1);
        	maxArea = Math.max(maxArea, h*w);
        }
        return maxArea;
        //其实这个做法就是把数组中的每个元素都作为矩形高度，计算了一遍该高度下矩形的最大面积。只是每次都贪心最大，避免了重复计算，所以效率高。
    }
}
