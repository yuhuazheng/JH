package Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSetII {

	public List<List<Integer>> subsetsWithDup(int[] num) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> emty = new ArrayList<Integer>();
		res.add(emty);
		if(num==null || num.length<1){
			return res;
		}
		
		Arrays.sort(num);
		int start=0;
		for(int i=0; i<num.length;i++){
			int size = res.size();
			for(int j=start; j<size;j++){
				List<Integer> item = new ArrayList<Integer>(res.get(j));
				item.add(num[i]);
				res.add(item);
			}
			if(i<num.length-1 && num[i]==num[i+1]){
				start = size; //only impact the newly added part by previous dup; otherwise dups in res
			}
			else{
				start =0;
			}
		}
		return res;
	}
}
