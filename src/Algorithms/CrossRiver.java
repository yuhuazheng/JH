package Algorithms;

import java.util.Arrays;

/**
 * Created by yuhua on 7/29/15.
 */
public class CrossRiver {
    public static void main(String[] args){
        int[] R = {1,1,1,0,1,1,0,0};
        System.out.println(minJumps(R));
    }

    public static int minJumps(int[] R){
        int n=R.length;
        int[][] steps = new int[n][(int)Math.sqrt(n * 2) + 1]; //steps[i][j] is min steps to arrive i with speed j
        //(int)Math.sqrt(n * 2) + 1 is very important, it actually constrains the limit of speed for each i.
        //otherwise, i might have super speed and to reduce the actual steps.
        //suppose all R==1, upper limit 1+2+..+j = j(j+1)/2 = i, j^2+j = i*2, -> j <= sqrt(i*2)
        int minSum = Integer.MAX_VALUE;

        for(int i=1;i<n;i++){
            Arrays.fill(steps[i], -1);
            if(R[i]==0)
                continue;

            for(int j=1;j<(int)Math.sqrt(i * 2) + 1;j++){
                if(R[i-j]==0){
                    steps[i][j]=-1;
                    continue;
                }
                if(steps[i-j][j]==-1&&steps[i-j][j-1]==-1){
                    continue;
                }
                if(steps[i-j][j]!=-1)
                    steps[i][j]=steps[i-j][j]+1;
                if(j>1&&steps[i-j][j-1]!=-1){
                    if(steps[i][j]==-1)
                        steps[i][j]=steps[i-j][j-1]+1;
                    else
                        steps[i][j]=Math.min(steps[i][j],steps[i-j][j-1]+1);
                }
                if(i+j+1>=n)
                    minSum=Math.min(minSum,steps[i][j]+1);

            }
        }
        return minSum;
    }
}
