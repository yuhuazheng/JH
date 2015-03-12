package Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
	
	public static void main(String[] args){
		int[] candidates = {10,1,2,7,6,1,5};
		CombinationSum2 helper = new CombinationSum2();
		List<List<Integer>> res = helper.combinationSum2(candidates, 8);
		System.out.println(res.size());
	}
	
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(candidates==null || candidates.length<1 || target<=0){
			return res;
		}
		
		//clean candidates to be sorted
		int[] numbers = candidates.clone();
		Arrays.sort(numbers);
		if(numbers[0]>target){
			return res;
		}
		combSumRecursive2(numbers,target,0, new ArrayList<Integer>(), res);
		return res;
	}
	
	private void combSumRecursive2(int[] numbers, int target, int k, ArrayList<Integer> curRes, List<List<Integer>> res) {
		if(target<0){
			return;
		}
		if(target==0){
			res.add(new ArrayList<Integer>(curRes));
			return;
		}
		for(int i=k;i<numbers.length;i++){
			if(i>k&&numbers[i]==numbers[i-1]){
				continue;
				//if a valid solution need to use the same more than once, it has appeared for the first time this value shows.
				//the later duplicates can be skipped.
			}
			curRes.add(numbers[i]);
			combSumRecursive2(numbers,target-numbers[i],i+1,curRes,res);
			curRes.remove(curRes.size()-1); //remove current number; keep all previous ones; and move on to next
		}
		return;
	}
}
