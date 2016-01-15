package Algorithms;

/**
 * Created by yuhua on 1/14/16.
 */
public class StockCooldown {
    public static void main(String[] args) {
        int[] prices = {1,2,3,0,2};
        StockCooldown inst = new StockCooldown();
        System.out.println(inst.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        if(prices==null||prices.length==0) return 0;
        //state machine:
        //every step only depends on previous states, and take optimal move for current moment
        int buy=-prices[0]; //profit if today buys
        int sell=Integer.MIN_VALUE; //profit if today sells
        int rest=0; //profit if today rest
        for(int i=1;i<prices.length;i++){
            int next_rest = Math.max(rest,sell);
            int next_buy = Math.max(buy,rest-prices[i]);
            int next_sell = buy+prices[i];
            buy=next_buy;
            sell=next_sell;
            rest=next_rest;
        }
        return Math.max(rest,Math.max(buy,sell));
    }
}
