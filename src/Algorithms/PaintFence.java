package Algorithms;

/**
 * Created by yuhua on 9/10/15.
 */
public class PaintFence {
    public int numWays(int n, int k) {
        //no more than 2 adjacent fences can have same color
        //t(n)=s(n)+d(n); s(n) last two have same color, d(n) last two have different colors
        //d(n)=(k-1)*t(n-1)
        //s(n)=d(n-1)=(k-1)*t(n-2)
        //t(n)=(k-1)*(t(n-1)+t(n-2))

        if(n<=0||k<=0) return 0;
        if(n==1) return k;
        if(n==2) return k*k;

        int t2=k;
        int t1=k*k;
        int t=0;
        for(int i=3;i<=n;i++){
            t=(k-1)*(t2+t1);
            t2=t1;
            t1=t;
        }
        return t;
    }
}
