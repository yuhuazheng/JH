package Algorithms;

import java.util.Arrays;

/**
 * Created by yuhuazh on 9/29/2015.
 */
public class wiggetSort {

    public static void main(String[] args) {
        int[] nums = {2,1};
        System.out.println(Arrays.toString(nums));
        wiggetSort inst = new wiggetSort();
        inst.wSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void wSort(int[] nums) {
        int n = nums.length;
        for(int i=1; i<n; i++) {
            if((i%2!=0 && nums[i]<nums[i-1]) || ((i%2==0) && nums[i]>nums[i-1])){
                //the comparison actually is local. one element only compare with left and right neighbors, no further.
                //so scan from left to right, compare only to its left, swap.
                swap(nums, i, i-1);
            }
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
