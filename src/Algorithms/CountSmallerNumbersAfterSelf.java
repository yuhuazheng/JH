package Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by yuhuazh on 5/16/2016.
 */
public class CountSmallerNumbersAfterSelf {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        if(nums==null||n==0) return res;

        Integer[] count = new Integer[n];
        List<Integer> q = new ArrayList<>();
        count[n-1]=0;
        q.add(nums[n-1]);
        for(int i=n-2;i>=0;i--){
            int cur = nums[i];
            int idx = binaryInsert(cur, q);
            count[i]=idx;
        }
        return Arrays.asList(count);
    }

    private int binaryInsert(int v, List<Integer> q){
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
        q.add(idx,v);
        return idx;
    }

    public static void main(String[] args) {
        int[] nums = {5,2,6,1};
        CountSmallerNumbersAfterSelf inst  = new CountSmallerNumbersAfterSelf();
        List<Integer> res = inst.countSmaller(nums);
        for(int r: res){
            System.out.print(r);
            System.out.print(",");
        }
    }
}
