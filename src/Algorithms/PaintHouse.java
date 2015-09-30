package Algorithms;

import java.util.Arrays;

/**
 * Created by yuhuazh on 9/30/2015.
 */
public class PaintHouse {

    public int minCost(int[][] costs) {
        if(costs==null||costs.length==0||costs[0].length==0) return 0;

        int n=costs.length;
        int c=costs[0].length;

        if(n==1){
            Arrays.sort(costs[0]);
            return costs[0][0];
        }

        int[] pre = new int[c];
        int[] cur = new int[c];

        for(int t=0;t<c;t++){
            pre[t]=costs[0][t];
        }

        for(int i=1;i<n;i++){
            for(int j=0;j<c;j++){
                //if current house is with color j, find the previous min cost
                int preMin=Integer.MAX_VALUE;
                for(int k=0;k<c;k++){
                    if(k!=j){
                        preMin=Math.min(preMin,pre[k]);
                    }
                }
                //if current color is j, the cumulative cost is how many
                cur[j]=preMin+costs[i][j];
            }
            //move to next house
            for(int s=0;s<c;s++){
                pre[s]=cur[s];
            }
        }

        int minCost=Integer.MAX_VALUE;
        for(int k=0;k<c;k++){
            minCost=Math.min(minCost,cur[k]);
        }
        return minCost;
    }
}
