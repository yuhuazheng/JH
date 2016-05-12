package Algorithms;


public class BurstBalls {
    /*public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] values = new int[n+2];
        for(int i=1;i<=n;i++)
            values[i]=nums[i-1];
        values[0]=values[n+1]=1;
        int[][] dp = new int[n+2][n+2];
        return DP(1,n,values,dp);
    }

    private int DP(int l, int r, int[] values, int[][] dp){
        if(dp[l][r]>0) return dp[l][r];
        for(int m=l;m<=r;m++){
            dp[l][r]=Math.max(dp[l][r], DP(l,m-1,values,dp)+values[l-1]*values[m]*values[r+1]+DP(m+1,r,values,dp));
        }
        return dp[l][r];
    }*/

    public int maxCoins(int[] iNums) {
        int n = iNums.length;
        int[] nums = new int[n + 2];
        System.arraycopy(iNums, 0, nums, 1, n);
        nums[0] = nums[n + 1] = 1;
        int[][] dp = new int[n + 2][n + 2];
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n - k + 1; i++) {
                int j = i + k - 1;
                for (int x = i; x <= j; x++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][x - 1] + nums[i - 1] * nums[x] * nums[j + 1] + dp[x + 1][j]);
                }
            }
        }
        return dp[1][n];
    }
}
