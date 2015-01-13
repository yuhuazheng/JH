package myPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	public static void main(String[] args){
		int[] num = {-1,0,1,2,-1,-4};
		ThreeSum helper = new ThreeSum();
		List<List<Integer>> results = helper.threeSum(num);
		for(List<Integer> oneRes : results){
			System.out.println(oneRes);
		}
	}
	
	public List<List<Integer>> threeSum(int[] num) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		
		if(num==null || num.length<3){
			return results;
		}
		
		Arrays.sort(num);
		for(int i=0; i<num.length-2; i++){
			if(i>0&&num[i]==num[i-1]){
				continue;
			}
			List<List<Integer>> results2 = TwoSum(num,-num[i],i+1);
			if(!results2.isEmpty()){
				for(List<Integer> oneSol: results2){
					oneSol.add(0, num[i]);
					results.add(oneSol);
				}
			}
		}
		return results;
    }
	
	public List<List<Integer>> TwoSum(int[] num, int target, int start){
		List<List<Integer>> results2 = new ArrayList<List<Integer>>();
		
		if(num==null || num.length<2){
			return results2;
		}
		
		int idx1=start;
		int idx2=num.length-1;
		while(idx1<idx2){
			if(target-num[idx1]<num[idx2]){
				idx2--;
			}
			else if(target-num[idx1]>num[idx2]){
				idx1++;
			}
			else{
				List<Integer> oneSol = new ArrayList<Integer>();
				oneSol.add(num[idx1]);
				oneSol.add(num[idx2]);
				results2.add(oneSol);
				idx1++;
				idx2--;
				while(num[idx1]==num[idx1-1]&& idx1<num.length-1){
					idx1++;
				}
				while(num[idx2]==num[idx2+1]&& idx2>=start){
					idx2--;
				}
			}
		}
		return results2;
	}
}
