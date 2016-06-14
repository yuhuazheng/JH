import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuhuazh on 6/13/2016.
 */
public class CountNumbers {
    public int countNumbersWithUniqueDigits(int n) {
        if(n==0) return 1;

        boolean[] used = new boolean[10];
        int[] count  = new int[1];
        helper(n,used,true,count);
        return count[0]+1;
    }

    private void helper(int k, boolean[] used, boolean prefixZeros,int[] count){
        if(k==0){
            if(!prefixZeros)
                count[0]++;
            return;
        }

        for (int i = 0; i < 10; i++) {
            if(i==0 && prefixZeros){
                helper(k-1,used,true,count);
                continue;
            }

            if (used[i])
                continue;
            used[i] = true;
            helper(k - 1, used, false,count);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        CountNumbers inst = new CountNumbers();
        System.out.println(inst.countNumbersWithUniqueDigits(1));
    }
}
