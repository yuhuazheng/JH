package Algorithms;

/**
 * Created by yuhua on 5/11/16.
 */
public class PaintHouseII {
    public int minCostII(int[][] costs) {
        if(costs==null||costs.length==0||costs[0].length==0) return 0;
        int n = costs.length;
        int k = costs[0].length;
        int[] local = new int[k];
        int preMin = 0;
        int preSec = 0;
        int preIdx = -1;

        for(int i=0;i<n;i++){
            int[] temp = new int[k];
            int curMin = Integer.MAX_VALUE;
            int curSec = Integer.MAX_VALUE;
            int curIdx = -1;
            for(int j=0;j<k;j++){
                temp[j]=costs[i][j]+(j==preIdx? preSec: preMin);
                if(temp[j]<curMin){
                    curSec = curMin;
                    curMin = temp[j];
                    curIdx = j;
                } else if(temp[j]<curSec) {
                    curSec = temp[j];
                }
            }
            preIdx=curIdx;
            preMin=curMin;
            preSec=curSec;
            local = temp;
        }

        return preMin;
    }
}
