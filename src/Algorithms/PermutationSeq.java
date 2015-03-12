package Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PermutationSeq {

	public static void main(String[] args){
		PermutationSeq helper = new PermutationSeq();
		System.out.println(helper.getPermutation(3, 5));
	}
	
	public String getPermutation(int n, int k) {
		if(n<0){
			return "";
		}
		int upper = 1;
		for(int i=n;i>=1;i--){
			upper *=i;
		}
		if(k>upper){
			return "";
		}
		
		ArrayList<Integer> count = new ArrayList<Integer>();
		count.add(0);
		ArrayList<String> numbers = new ArrayList<String>();
		for(int i=1;i<=n;i++){
			numbers.add(Integer.toString(i));
		}
		String[] res={""};
		kthPermutation(count,n,k,res,numbers);
		return res[0];
	}
	
	private void kthPermutation(ArrayList<Integer> count,int n, int k, String[] res, ArrayList<String> numbers){
		if(numbers.size()==1){
			count.set(0, count.get(0)+1);
			if(count.get(0)==k){
				res[0] = res[0] + numbers.get(0);
				return;
			}
			else{
				return;
			}
		}
		
		for(int i=0; i<numbers.size();i++){
			Collections.sort(numbers);
			String curNumber =  numbers.get(i);
			res[0] = res[0] + curNumber;
			numbers.remove(i);
			kthPermutation(count,n,k,res,numbers);
			if(res[0].length()==n){
				return;
			}
			else{
				numbers.add(curNumber);
				res[0] = res[0].substring(0, res[0].length()-1);
			}
		}
		return;
	}
}
