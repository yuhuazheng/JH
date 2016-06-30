import java.util.Arrays;

/**
 * Created by yuhua on 29/06/16.
 */
public class RangeAddition {
    public int[] getModifiedArray(int length, int[][] updates) {
        if(length==0){
            return new int[0];
        }
        int[] res = new int[length];
        Arrays.fill(res,0);
        if(updates==null||updates.length==0||updates[0].length==0)
            return res;

        for(int[] u: updates){
            res[u[0]]+=u[2];
            if(u[1]+1<length)
                res[u[1]+1]+=-u[2];
        }

        int curInc=0;
        for(int i=0;i<length;i++){
            int temp=res[i]+curInc;
            curInc+=res[i];
            res[i]=temp;
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] updates = {
                {1,3,2},
                {2,4,3},
                {0,2,-2},
        };
        RangeAddition inst = new RangeAddition();
        int[] res = inst.getModifiedArray(5,updates);
    }
}
