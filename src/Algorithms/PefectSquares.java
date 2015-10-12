package Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yuhuazh on 10/11/2015.
 */
public class PefectSquares {

    public static void main(String[] args){
        PefectSquares inst = new PefectSquares();
        System.out.println(inst.numSquares(7168));
    }

    public int numSquares(int n) {
        if(n<=1) return 1;
        int[] buf = new int[n+1];
        Arrays.fill(buf,Integer.MAX_VALUE);
        for(int i=1;i*i<=n;i++)
            buf[i*i]=1;

        for(int i=1;i<=n;i++){
            for(int j=1;i+j*j<=n;j++) {
                buf[i + j * j] = Math.min(buf[i] + 1, buf[i + j * j]);
            }
        }
        return buf[n];
    }
}
