package Algorithms;

import java.util.Arrays;

/**
 * Created by yuhuazh on 4/13/2016.
 */
public class WiggleSortII {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[] temp = new int[nums.length];
        int s = (nums.length + 1) >> 1, t = nums.length;
        for (int i = 0; i < nums.length; i++) {
            temp[i] = (i & 1) == 0 ?  nums[--s] : nums[--t] ;
        }

        for (int i = 0; i < nums.length; i++)
            nums[i] = temp[i];
    }

    public static void main(String[] args) {
        int[] nums = {5,3,1,2,6,7,8,5,5};
        WiggleSortII inst = new WiggleSortII();
        inst.wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
