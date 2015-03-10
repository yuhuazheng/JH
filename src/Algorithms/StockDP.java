package Algorithms;

public class StockDP {

	public int maxProfit(int[] prices) {
		if(prices==null || prices.length<2){
			return 0;
		}
		int global=0;
		int local=0;
		for(int i=1;i<prices.length;i++){
			local=Math.max(0, local+prices[i]-prices[i-1]);
			global=Math.max(local, global);
		}
		return global;
	}
}
