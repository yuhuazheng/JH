package Algorithms;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by yuhuazh on 3/8/2016.
 */
public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        if(nums.length==1) return 1;
//        int[] res = new int[nums.length];
//        Arrays.fill(res, 1);
//        int glb=1;
//
//        for(int i=1;i<nums.length;i++){
//            for (int j = 0; j < i; j++) {
//                if(nums[i]>nums[j] && res[j]+1>res[i]) {
//                    res[i] = res[j] + 1;
//                    if (res[i] > glb)
//                        glb = res[i];
//                }
//            }
//        }
//        return glb;

        ArrayList<Integer> LIS = new ArrayList<>();
        LIS.add(nums[0]);
        for(int i=1;i<nums.length;i++){
            if(nums[i]>LIS.get(LIS.size()-1))//bigger than current tail, append
                LIS.add(nums[i]);
            else{//insert current to the place so that the whole LIS has better potential to grow
                int pos=findInArrayList(LIS,nums[i]);
                LIS.remove(pos);
                LIS.add(pos,nums[i]);
            }
        }
        return LIS.size(); //LIS holds the longest
    }

    private int findInArrayList(ArrayList<Integer> LIS, int num){
        int l=0;
        int r=LIS.size()-1;
        while(l<=r){
            int m = (l+r)/2;
            if(LIS.get(m)==num) return m;
            if(LIS.get(m)>num) r=m-1;
            else l=m+1;
        }
        return l;
    }

    public static void main(String[] args){
        LongestIncreasingSubsequence inst = new LongestIncreasingSubsequence();
        int[] nums = {1,3,6,7,9,4,10,5,6};
        System.out.println(inst.lengthOfLIS(nums));
    }
}
