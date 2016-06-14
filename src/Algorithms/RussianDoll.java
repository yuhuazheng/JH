import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by yuhuazh on 6/13/2016.
 */
public class RussianDoll {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes==null||envelopes.length==0||envelopes[0].length==0) return 0;

        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]==o2[0]?o1[1]-o2[1]:o1[0]-o2[0];
            }
        });

        int m=envelopes.length;
        int[] buf = new int[m];
        Arrays.fill(buf,1);
        int maxLen=1;
        for(int i=1;i<m;i++){
            for(int j=i-1;j>=0;j--){
                if(envelopes[i][0]>envelopes[j][0]&&envelopes[i][1]>envelopes[j][1]){
                    buf[i]=Math.max(buf[i],1+buf[j]);
                    maxLen = Math.max(maxLen,buf[i]);
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        RussianDoll inst = new RussianDoll();
        int[][] envelopes = {
                {5,4},
                {6,4},
                {6,7},
                {2,3},
        };
        System.out.println(inst.maxEnvelopes(envelopes));
    }
}
