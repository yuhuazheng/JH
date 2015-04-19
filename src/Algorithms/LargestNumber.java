package Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class LargestNumber {

	public static void main(String[] args){
		Integer[] n = {3, 30, 34, 5, 9};
		List<Integer> num = Arrays.asList(n);
		LargestNumber inst = new LargestNumber();
		System.out.println(inst.largestNumber(num));
	}
	
	public String largestNumber(List<Integer> num) {
		 if(num==null || num.size()<1){
			 return "";
		 }
		 Comparator<String> customCompare = new digitComparator();
		 PriorityQueue<String> nums = new PriorityQueue<String>(10,customCompare);
		 for(int i=0; i<num.size();i++){
			 nums.add(num.get(i).toString());
		 }
		 StringBuilder res = new StringBuilder();
		 
		 while(!nums.isEmpty()){
			 res.append(nums.poll());
		 }
		 if(res.indexOf("0")==0){ //result is a valid number; so that 0000 will be 0
			 return "0";
		 }
		 return res.toString();
	 }
	 
	 public class digitComparator implements Comparator<String>{
		 @Override
		 public int compare(String s1, String s2){
			 String r1=s1+s2;
			 String r2=s2+s1;
			 for(int i=0;i<r1.length();i++){
				 char c1=r1.charAt(i);
				 char c2=r2.charAt(i);
				 if(c1-c2>0){
					 return -1;
				 }
				 if(c1-c2<0){
					 return 1;
				 }
			 }
			 return 0;
		 }
	 }
}
