package Algorithms;

import java.util.HashMap;

/**
 * Created by yuhua on 1/28/16.
 */
public class MaxSizeSubarraySumK {

    public static void main(String[] args) {
        int[] nums = {4,8,0,-2,5,2,-8,7,1,-4,4,8,-2,5,-5,-2,8};
        int k=0;
        MaxSizeSubarraySumK inst  = new MaxSizeSubarraySumK();
        System.out.println(inst.maxSubArrayLen(nums,k));
    }

    public int maxSubArrayLen(int[] nums, int k) {
        if(nums==null||nums.length==0) return 0;
        HashMap<Integer,Integer> accuSum = new HashMap<>();
        int curSum=0;
        int len=0;
        for(int i=0;i<nums.length;i++){
            curSum+=nums[i];
            if(curSum==k){ //special case
                len = Math.max(len,i+1);
            }
            int toFind = curSum-k;
            if(accuSum.containsKey(toFind)){//always look backwards
                len=Math.max(len, i-accuSum.get(toFind));
            }
            if(nums[i]==0) {//0 has no impact
                continue;
            }
            if(!accuSum.containsKey(curSum)){ //keep the furthest accumulative sum, meaning longest subarray
                accuSum.put(curSum,i);
            }
        }
        return len;
    }
}
