package Algorithms;

import java.util.ArrayList;

public class PermutationSeq2 {

	public String getPermutation(int n, int k) {
		if(n<=0){
			return "";
		}
		k--; // to match with starting from zero
		StringBuilder res = new StringBuilder();
		int factorial =1;
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for(int i=2;i<n;i++){
			factorial *=i;
		}
		for(int i=1;i<=n;i++){
			nums.add(i);
		}
		int round=n-1;
		while(round>=0){
			int idx = k/factorial; //right-shift one bit corresponds to (n-1)!
			k %=factorial;
			res.append(nums.get(idx));
			nums.remove(idx);
			if(round>0){
				factorial /=round;
			}
			round--;
		}
		return res.toString();
	}
}
