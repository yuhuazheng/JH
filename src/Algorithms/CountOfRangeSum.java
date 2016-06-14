import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by yuhuazh on 6/14/2016.
 */
public class CountOfRangeSum {
    public int countRangeSum(int[] nums, int lower, int upper) {
        if(nums==null || nums.length==0) return 0;

        int m=nums.length;
        long[] sums = new long[m+1]; //add an extra zero at front to make later computation easy to read
        for(int i=1;i<=m;i++){
            sums[i]=sums[i-1]+nums[i-1];
        }

        int count=0;
        List<Long> q = new ArrayList<>();
        q.add(sums[m]);
        for(int i=m-1;i>=0;i--){
            int l = binaryLocateLeft(lower+sums[i],q);
            int h = binaryLocateRight(upper+sums[i],q);
            count+=h-l;
            int idx =  binaryLocateLeft(sums[i],q);
            q.add(idx,sums[i]);
        }
        return count;
    }

    private int binaryLocateLeft(long v, List<Long> q){
        int l=0;
        int r = q.size()-1;
        while(l<r){
            int m = (l+r)/2;
            if(q.get(m)>=v){
                r=m-1;
            }
            else{
                l=m+1;
            }
        }
        int idx=q.get(l)>=v?l:l+1;
        return idx;
    }

    private int binaryLocateRight(long v, List<Long> q){
        int l=0;
        int r = q.size()-1;
        while(l<r){
            int m = (l+r)/2;
            if(q.get(m)>v){
                r=m-1;
            }
            else{
                l=m+1;
            }
        }
        int idx=q.get(l)<=v?l+1:l;
        return idx;
    }

    public static void main(String[] args) {
        CountOfRangeSum inst = new CountOfRangeSum();
        int[] nums = {-2147483647,0,0,0};
        System.out.println(inst.countRangeSum(nums,-2775,2201));
    }
}
