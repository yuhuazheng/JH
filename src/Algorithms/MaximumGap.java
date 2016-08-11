import java.util.Arrays;

public class MaximumGap {

	public static void main(String[] args){
		int[] num={3,6,9,1};

		MaximumGap helper = new MaximumGap();
		System.out.println(helper.maximumGap(num));
	}

	public int maximumGap(int[] nums) {
		if(nums==null||nums.length<2) return 0;
		if(nums.length==2) return Math.abs(nums[0]-nums[1]);

		int low=nums[0];
		int hi=nums[0];
		for(int i:nums){
			low=Math.min(low,i);
			hi=Math.max(hi,i);
		}
		if(low==hi) return 0;
		int n=nums.length;
		int width=(int)Math.ceil((double)(hi-low)/(n-1));

		int[][] buckets = new int[n-1][2];
		for(int i:nums){
			if(i==low||i==hi) continue;
			int idx = (i-low)/width;
			if(buckets[idx][0]==0||i<buckets[idx][0])
				buckets[idx][0]=i;
			if(i>buckets[idx][1])
				buckets[idx][1]=i;
		}

		int maxGap=0;
		int pre=low;
		for(int j=0;j<n-1;j++){
			if(buckets[j][0]==0&&buckets[j][1]==0) continue;
			maxGap=Math.max(maxGap,buckets[j][0]-pre);
			maxGap=Math.max(maxGap,buckets[j][1]-buckets[j][0]);
			pre=buckets[j][1];
		}
		maxGap=Math.max(maxGap,hi-pre);
		return maxGap;
	}
}
