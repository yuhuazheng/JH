package Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationII {

	public static void main(String[] args){
		int[] num={-1,-1,3,-1};
		PermutationII inst = new PermutationII();
		List<List<Integer>> res = inst.permuteUnique(num);
		System.out.println(res.size());
	}
	
	public List<List<Integer>> permuteUnique(int[] num) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(num==null || num.length<1){
			return res;
		}
		Arrays.sort(num);
		helper(num,new boolean[num.length],new ArrayList<Integer>(), res);
		return res;
	}
	
	private void helper(int[] num, boolean[] used, ArrayList<Integer> cur,List<List<Integer>> res){
		if(cur.size()==num.length){
			res.add(new ArrayList<Integer>(cur));
			return;
		}
		for(int i=0; i<num.length;i++){
			if(i>0 && !used[i-1] && num[i]==num[i-1]){
				continue;
			}
			if(!used[i]){
				used[i]=true;
				cur.add(num[i]);
				helper(num,used,cur,res);
				cur.remove(cur.size()-1);
				used[i]=false;
			}
		}
		return;
	}
}
