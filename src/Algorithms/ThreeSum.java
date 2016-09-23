
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

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if(nums==null||nums.length<3)
			return res;

		Arrays.sort(nums);
		for(int i=0;i<nums.length-2;i++){
			if(i>0&&nums[i]==nums[i-1])
				continue;

			int l=i+1;
			int r=nums.length-1;
			int target = -nums[i];
			while(l<r){
				int sum = nums[l]+nums[r];
				if(sum>target){
					r--;
				}
				else if(sum<target){
					l++;
				}
				else{
					List<Integer> temp = new ArrayList<>();
					temp.add(nums[l]);
					temp.add(nums[r]);
					temp.add(nums[i]);
					res.add(temp);
					l++;
					r--;
					while(l<r&&nums[l]==nums[l-1])
						l++;
					while(l<r&&nums[r]==nums[r+1])
						r--;
				}
			}
		}
		return res;
	}

	/*
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
	*/
}
