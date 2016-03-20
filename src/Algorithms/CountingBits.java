package Algorithms;

/**
 * Created by yuhuazh on 3/19/2016.
 */
public class CountingBits {
    public int[] countBits(int num) {
        if(num<0) return new int[]{-1};
        if(num==0) return new int[]{0};
        if(num==1) return new int[]{0,1};

        int[] res = new int[num+1];
        res[0]=0;
        res[1]=1;
        int m=1; //the highest bit of 1; defines the range
        int lowwerBound = (int)Math.pow(2.0,m);
        int upperBound = (int)Math.pow(2.0,m+1);
        for(int i=2;i<=num;i++){
            if(i==upperBound){
                m++;
                lowwerBound = (int)Math.pow(2.0,m);
                upperBound = (int)Math.pow(2.0,m+1);
            }
            int offset = i-lowwerBound;
            res[i]=1+res[offset];
        }
        return res;
    }

    public static void main(String[] args) {
        CountingBits inst = new CountingBits();
        int[] res = inst.countBits(15);
        for(int r : res){
            System.out.print(r);
            System.out.print(',');
        }
    }
}
