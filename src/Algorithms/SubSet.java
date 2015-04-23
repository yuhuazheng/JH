package Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSet {

	public static void main(String[] args){
		int[] num = {1,2,3};
		SubSet inst = new SubSet();
		List<List<Integer>> res = inst.subsets(num);
		for(List<Integer> cur : res){
			System.out.println(Arrays.toString(cur.toArray()));
		}
	}
	
	public List<List<Integer>> subsets(int[] S) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> emty = new ArrayList<Integer>();
		res.add(emty);
		if(S==null || S.length<1){
			return res;
		}
		
		Arrays.sort(S);
		for(int i=0; i<S.length;i++){
			int size = res.size();
			for(int j=0; j<size;j++){
				List<Integer> item = new ArrayList<Integer>(res.get(j));
				item.add(S[i]);
				res.add(item);
			}
		}
		return res;
	}
}
