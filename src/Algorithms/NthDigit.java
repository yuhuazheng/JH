/**
 * Created by yuhua on 19/10/16.
 */
public class NthDigit {
    public int findNthDigit(int n) {
        if(n==1)
            return 1;

        long base=9;
        int step=1;

        while(n>base*step){
            n-=(int)base*step;
            step+=1;
            base*=10;
        }

        int numIdx = (n-1)/step;
        int digIdx = (n-1)%step;

        int num = (int)Math.pow(10,step-1)+numIdx;
        int res = Integer.parseInt(String.valueOf(num).charAt(digIdx)+"");

        return res;
    }

    public static void main(String[] args) {
        NthDigit inst = new NthDigit();
        int n=2147483647;
        System.out.println(inst.findNthDigit(n));
    }
}
