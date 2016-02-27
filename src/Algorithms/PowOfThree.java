package Algorithms;

/**
 * Created by yuhua on 2/21/16.
 */
public class PowOfThree {

    public boolean isPowerOfThree(int n) {
        if(n<=0){
            return false;
        }
        else{
            return Integer.toString(n,3).matches("10*");
        }
    }
}
