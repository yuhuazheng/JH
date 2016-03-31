package Algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuhua on 3/29/16.
 */
public class MajorityElementII {

    public static void main(String[] args) {
        MajorityElementII inst = new MajorityElementII();
        int[] nums = {1,1,1,3,3,2,2,2};
        List<Integer> res = inst.majorityElement(nums);
        for(int c: res){
            System.out.print(c);
            System.out.print(',');
        }
    }

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums==null||nums.length==0) return res;
        res.add(nums[0]);
        if(nums.length==1||(nums.length==2&&nums[0]==nums[1]) )
            return res;
        res.add(nums[1]);
        if(nums.length==2)
            return res;

        int n0=Integer.MIN_VALUE;
        int n1=Integer.MIN_VALUE;
        int c0=0;
        int c1=0;

        //find candidates
        for(int i=0;i<nums.length;i++){
            int c=nums[i];
            if(c==n0)
                c0++;
            else if(c==n1)
                c1++;
            else if(c0==0) {
                n0=c;
                c0 = 1;
            }
            else if(c1==0) {
                n1=c;
                c1 = 1;
            }
            else{
                c1--;
                c0--;
            }
        }

        //validate candidates
        c0=c1=0;
        for(int c : nums){
            if(c==n0)
                c0++;
            else if(c==n1)
                c1++;
        }
        res = new ArrayList<Integer>();
        if(c0>nums.length/3)
            res.add(n0);
        if(c1>nums.length/3)
            res.add(n1);

        return res;
    }
}
