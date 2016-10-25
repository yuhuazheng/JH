/**
 * Created by yuhua on 19/10/16.
 */
public class NthDigit {
    public int findNthDigit(int n) {
        if(n==1)
            return 1;

        long v=1;
        int step=1;
        long bound=10;
        long cur=1;

        while(cur<=n){
            v+=1;
            if(v>=bound){
                step+=1;
                bound*=10;
            }
            cur+=step;
            if(cur>=n){
                int diff=(int)(cur-n);
                int i=diff;
                long temp=v;
                while(i>0){
                    temp/=10;
                    i--;
                }
                return (int)temp%10;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        NthDigit inst = new NthDigit();
        int n=2147483647;
        System.out.println(inst.findNthDigit(n));
    }
}
