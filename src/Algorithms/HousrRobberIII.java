package Algorithms;

/**
 * Created by yuhuazh on 3/16/2016.
 */
public class HousrRobberIII {

    //recursion costs 1116ms
//    public int rob(TreeNode root) {
//        if(root==null) return 0;
//        return Math.max(rob(root.left)+rob(root.right), norob(root.left)+norob(root.right)+root.val);
//    }
//
//    private int norob(TreeNode root){
//        if(root==null) return 0;
//        return rob(root.left)+rob(root.right);
//    }

    //instead repeat on each node during recursion, store the intermediate value, costs only 1ms
    public int rob(TreeNode root) {
        return dfs(root)[0];
    }

    private int[] dfs(TreeNode root) {
        int dp[]={0,0}; //dp[0]: rob, dp[1]: no_rob
        if(root != null){
            int[] dp_L = dfs(root.left);
            int[] dp_R = dfs(root.right);
            dp[1] = dp_L[0] + dp_R[0];
            dp[0] = Math.max(dp[1] ,dp_L[1] + dp_R[1] + root.val);
        }
        return dp;
    }

}
