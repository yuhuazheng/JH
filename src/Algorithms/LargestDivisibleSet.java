import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yuhuazh on 6/30/2016.
 */
public class LargestDivisibleSet {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums==null||nums.length==0) return res;
        Arrays.sort(nums);
        int n = nums.length;

        int[] dp = new int[n];
        int[] index = new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(index,-1);
        int max_dp=1;
        int max_idx=0;

        for(int i=0;i<n;i++){
            for(int j=i-1;j>=0;j--){
                if(nums[i]%nums[j]==0 && dp[j]+1>dp[i]){
                    dp[i]=dp[j]+1;
                    index[i]=j;
                }
            }
            if(dp[i]>max_dp){
                max_dp=dp[i];
                max_idx=i;
            }
        }

        for(int i=max_idx;i!=-1;i=index[i]){
            res.add(0,nums[i]);
        }

        return res;
    }
}
