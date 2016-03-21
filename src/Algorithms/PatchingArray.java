package Algorithms;

import java.util.Arrays;

/**
 * Created by yuhuazh on 3/20/2016.
 */
public class PatchingArray {
    public int minPatches(int[] nums, int n) {
        long missing = 1;
        int patches = 0, i = 0;

        while (missing <= n) {
            if (i < nums.length && nums[i] <= missing) {
                missing += nums[i++];
            }
            else {
                missing += missing;
                patches++;
            }
        }
        return patches;
    }

    public static void main(String[] args) {
        PatchingArray inst = new PatchingArray();
        int[] nums = {};
        int n=7;
        System.out.println(inst.minPatches(nums,n));
    }
}
