package Algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Permutations {

	public static void main(String[] args){
		int[] num = {1,2,3};
		Permutations helper = new Permutations();
		List<List<Integer>> res = helper.permute(num);
		System.out.println(res.size());
	}
	
	public List<List<Integer>> permute(int[] num) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(num==null || num.length<1){
			return res;
		}
		Queue<Integer> nums = new LinkedList<Integer>();
		for(int cur:num){
			nums.add(cur);
		}
		res = permuteLengthK(nums);
		return res;
	}
	
	private ArrayList<List<Integer>> permuteLengthK(Queue<Integer> nums){
		ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
		int k=nums.size();
		if(k==1){
			List<Integer> onePermute = new ArrayList<Integer>();
			onePermute.add(nums.peek());
			res.add(onePermute);
			return res;
		}
		for(int i=k;i>0;i--){
			int curNum = nums.poll();
			ArrayList<List<Integer>> subRes = permuteLengthK(nums);
			for(List<Integer> curRes : subRes){
				curRes.add(curNum);
			}
			res.addAll(subRes);
			nums.add(curNum);
		}
		return res;
	}
}
