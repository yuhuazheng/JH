package Algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuhuazh on 3/20/2016.
 */
public class MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<String>();
        int pre = lower-1;
        for(int i=0;i<=nums.length;i++){
            int cur = (i==nums.length)?upper+1:nums[i];
            if(cur-pre>1){
                res.add(findRange(pre+1,cur-1));
            }
            pre=cur;
        }
        return res;
    }

    private String findRange(int from, int to){
        if(from==to){
            return Integer.toString(from);
        }
        else{
            return Integer.toString(from)+"->"+Integer.toString(to);
        }
    }

    public static void main(String[] args) {
        MissingRanges inst = new MissingRanges();
        int[] nums = {0, 1, 3, 50, 75};
        int lower = 0;
        int upper = 99;
        List<String> res = inst.findMissingRanges(nums,lower,upper);
        for(String s : res){
            System.out.println(s);
        }
    }
}
