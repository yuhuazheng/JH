package Algorithms;

/**
 * Created by yuhuazh on 4/20/2016.
 */
public class PowerOfFour {
    public boolean isPowerOfFour(int num) {
        return (num>0) && (num&(num-1))==0 && ((num & 0x55555555)>0);
    }

    public static void main(String[] args) {
        PowerOfFour inst = new PowerOfFour();
        System.out.println(inst.isPowerOfFour(16));
    }
}
