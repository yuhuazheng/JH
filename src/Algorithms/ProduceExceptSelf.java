package Algorithms;

import java.util.Arrays;

/**
 * Created by yuhuazh on 10/1/2015.
 */
public class ProduceExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        if(nums==null||nums.length==0) return new int[0];
        int len = nums.length;
        int[] res = new int[len];
        Arrays.fill(res, 1);

        //from left to right
        for(int i=1;i<len;i++){
            res[i]=res[i-1]*nums[i-1];
        }
        //from right to left
        int carry=1;
        for(int i=len-1;i>=0;i--){
            res[i]*=carry;
            carry*=nums[i];
        }
        return res;
    }
}
