

public class Stock3 {

	public int maxProfit(int[] prices) {
		if(prices==null||prices.length<=1) return 0;
		int n=prices.length;
		int k=2;
		int[] local=new int[k+1];
		int[] global=new int[k+1];

		for(int i=1;i<n;i++){
			int diff=prices[i]-prices[i-1];
			for(int j=k;j>=1;j--){
				local[j]=Math.max(local[j]+diff,global[j-1]+diff);
				global[j]=Math.max(local[j],global[j]);
			}
		}
		return global[k];
	}
}
