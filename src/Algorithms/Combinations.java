package Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combinations {

	public static void main(String[] args){
		Combinations inst = new Combinations();
		List<List<Integer>> res = inst.combine(4, 2);
		for(List<Integer> item: res){
			System.out.println(Arrays.toString(item.toArray()));
		}
	}
	
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		
		if(k>n){
			return res;
		}
		helper(1,n,k,new ArrayList<Integer>(),res);
		return res;
	}
	
	private void helper(int start, int end, int k, List<Integer> item, List<List<Integer>> res){
		if(k==0 && item!=null && item.size()>0){
			res.add(new ArrayList<Integer>(item));
			return;
		}
		for(int i=start; i<=end-k+1; i++){
			item.add(i);
			helper(i+1,end,k-1,item,res);
			item.remove(item.size()-1);
		}
		return;
	}
}
