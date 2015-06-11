package Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum3 {

	public static void main(String[] args){
		CombinationSum3 helper = new CombinationSum3();
		List<List<Integer>> res = helper.combinationSum3(3, 9);
		for(List<Integer> curL:res){
			System.out.println(curL.toString());
		}
	}
	
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(k<1 || n<1){
			return res;
		}
		
		int[] numbers = new int[9];
		for (int i=0;i<9;i++){
			numbers[i]=i+1;
		}
		combSumRecursive3(numbers,n,k,0, new ArrayList<Integer>(), res);
		return res;
	}
	
	private void combSumRecursive3(int[] numbers, int target, int k, int start, ArrayList<Integer> curRes, List<List<Integer>> res) {
		if(target<0 || k<0){
			return;
		}
		if(target==0 && k==0){
			res.add(new ArrayList<Integer>(curRes));
			return;
		}
		for(int i=start;i<numbers.length;i++){
			curRes.add(numbers[i]);
			combSumRecursive3(numbers,target-numbers[i],k-1,i+1,curRes,res);
			curRes.remove(curRes.size()-1); //remove current number; keep all previous ones; and move on to next
		}
		return;
	}
}

