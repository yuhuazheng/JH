
public class SearchRange {

	public static void main(String[] main){
		int[] A = {5,7,7,9,9,10};
		int target = 9;
		SearchRange helper = new SearchRange();
		int[] range = helper.searchRange(A,target);
		System.out.println(range[0]);
		System.out.println(range[1]);
	}
	
	public int[] searchRange(int[] nums, int target){
		int[] res = new int[2];
		if(nums==null||nums.length==0){
			res[0]=res[1]=-1;
			return res;
		}

		int l=0;
		int r=nums.length-1;
		while(l<=r){
			int m= (l+r)/2;
			int v = nums[m];
			if(v<target)
				l=m+1;
			else
				r=m-1;
		}
		res[0]=(l<nums.length&&nums[l]==target)?l:-1;

		l=0;
		r=nums.length-1;
		while(l<=r){
			int m= (l+r)/2;
			int v = nums[m];
			if(v<=target)
				l=m+1;
			else
				r=m-1;
		}
		res[1]=(r>=0&&nums[r]==target)?r:-1;

		return res;
	}
}
