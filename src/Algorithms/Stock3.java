package Algorithms;

public class Stock3 {

	public int maxProfit(int[] prices) {
		if(prices==null || prices.length<2){
			return 0;
		}
		int[] local = new int[3]; //k=2; could be generalized
		int[] global = new int[3];
		for(int i=1;i<prices.length;i++){
			int diff=prices[i]-prices[i-1];
			for(int j=2;j>=1;j--){ //j is linear of k.
				local[j]=Math.max(local[j]+diff, global[j-1]+(diff>0?diff:0));
				global[j]=Math.max(global[j], local[j]);
			}
		}
		return global[2];
	}
}
