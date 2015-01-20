package myPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriagle {

	public static void main(String[] args){
		int numRows=1;
		PascalTriagle helper = new PascalTriagle();
		List<List<Integer>> nums = helper.generate(numRows);
		for(List<Integer> oneLine:nums){
			System.out.println(oneLine);
		}
	}
	
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> nums = new ArrayList<List<Integer>>();
		if(numRows<1){
			return nums;
		}
		
		List<Integer> row1 = new ArrayList<Integer>();
		row1.add(1);
		nums.add(row1);
		
		List<Integer> pre = row1;
		int value1=0;
		int value2=0;
		for(int num=2;num<=numRows; num++){
			List<Integer> cur = new ArrayList<Integer>();
			for(int idx=0;idx<num;idx++){
				if(idx-1<0){
					value1=0;
				}
				else{
					value1=pre.get(idx-1);
				}
				if(idx==num-1){
					value2=0;
				}
				else{
					value2=pre.get(idx);
				}
				cur.add(value1+value2);
			}
			nums.add(cur);
			pre=cur;
		}
		
		return nums;
    }
}
