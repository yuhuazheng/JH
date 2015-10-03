package Algorithms;

import java.util.Arrays;

/**
 * Created by yuhuazh on 10/2/2015.
 */
public class TreeSumSmaller {

    public static void main(String[] args){
        int[] nums = {-3,-1,-4,-4,0,-2,2};
        TreeSumSmaller inst = new TreeSumSmaller();
        System.out.println(inst.threeSumSmaller(nums,-8));
    }

    public int threeSumSmaller(int[] nums, int target) {
        if(nums==null || nums.length<3) return 0;
        Arrays.sort(nums);
        int count=0;
        for(int i=0;i<nums.length;i++){
            count+=twoSumSmaller(nums,target-nums[i],i+1);
        }
        return count;
    }

    private int twoSumSmaller(int[] nums, int target, int start){
        if(start>=nums.length) return 0;
        //if(target<nums[start]) return 0;

        int c=0;
        int l=start;
        int r=nums.length-1;
        while(l<r){
            if(nums[l]+nums[r]<target){
                c+=r-l;
                l++;
            }
            else{
                r--;
            }
        }
        return c;
    }

}
