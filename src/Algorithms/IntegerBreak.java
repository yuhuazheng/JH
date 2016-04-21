package Algorithms;

/**
 * Created by yuhuazh on 4/20/2016.
 */
public class IntegerBreak {
    //http://blog.csdn.net/liyuanbhu/article/details/51198124
    public int integerBreak(int n) {
        //factor of 3 generates max
        if(n == 2) return 1;
        if(n == 3) return 2;
        int ret = 1;
        while( n>4 )
        {
            ret *= 3;
            n -= 3;
        }
        return ret * n;
    }
}
