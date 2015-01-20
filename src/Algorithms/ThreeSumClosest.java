package myPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumClosest {

	public static void main(String[] args){
		int[] num = {1,1,-1,-1,3};
		ThreeSumClosest helper = new ThreeSumClosest();
		System.out.println(helper.threeSumClosest(num,1));
	}
	
	public int threeSumClosest(int[] num, int target) {
		
		if(num==null || num.length<3){
			return 0;
		}
		
		Arrays.sort(num);
		int Min = num[0]+num[1]+num[2]-target;
		int sum = num[0]+num[1]+num[2];
		
		for(int i=0; i<num.length-2; i++){
			int curSum = TwoSumClosest(num,target,i+1);
			int curMin = curSum-target;
			if(Math.abs(curMin)<Math.abs(Min)){
				Min=curMin;
				sum=curSum;
			}
		}
		return sum;
    }
	
	public int TwoSumClosest(int[] num, int target, int start){
				
		if(num==null || num.length<2){
			return target;
		}
		
		int idx1=start;
		int idx2=num.length-1;
		int Min= num[start-1]+num[idx1]+num[idx2]-target;
		
		while(idx1<idx2){
			int curMin = num[start-1]+num[idx1]+num[idx2]-target;
			if(Math.abs(curMin)<Math.abs(Min)){
				Min=curMin;
			}
			if(curMin>0){
				idx2--;
			}
			else if(curMin<0){
				idx1++;
			}
			else{
				return target;
			}
		}
		return Min+target;
	}
}
