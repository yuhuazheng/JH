package Algorithms;

import java.util.ArrayList;

/**
 * Created by yuhuazh on 4/9/2016.
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if(coins==null) return -1;
        if(coins.length==0){
            if(amount==0) return 0;
            return -1;
        }

        int dp[] = new int[amount + 1];
        final int INF = 0x7ffffffe;
        for (int i = 1; i <= amount; i++) dp[i] = INF;
        for (int i = 0; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i + coins[j] <= amount)
                    dp[i + coins[j]] = Math.min(dp[i + coins[j]], dp[i] + 1);
            }
        }
        return dp[amount] == INF ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins ={1,2,5};
        int amount=100;
        CoinChange inst = new CoinChange();
        System.out.println(inst.coinChange(coins,amount));
    }
}
