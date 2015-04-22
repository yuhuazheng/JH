package Algorithms;

import java.util.ArrayList;
import java.util.List;

public class GaryCode {

	public static void main(String[] args){
		GaryCode inst = new GaryCode();
		List<Integer> res =inst.grayCode(2);
		for(Integer c : res){
			System.out.println(c);
		}
	}
	
	public List<Integer> grayCode(int n) {
		if(n==0){
			List<Integer> res = new ArrayList<Integer>();
			res.add(0);
			return res;
		}
		
		List<Integer> temp = grayCode(n-1);
		int base=1<<(n-1);
		List<Integer> res = new ArrayList<Integer>(temp);
		for(int i=temp.size()-1;i>=0;i--){
			res.add(base+temp.get(i));
		}
		return res;
	}
}
