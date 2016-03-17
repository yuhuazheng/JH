package Algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuhuazh on 3/12/2016.
 */
public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        if(nums==null|| nums.length<3) return false;
        int k=3;
        List<Integer> res = new ArrayList<>();
        res.add(nums[0]);
        for(int i=1;i<nums.length;i++){
            int cur = nums[i];
            if(cur>res.get(res.size()-1)){
                res.add(cur);
            }
            else{
                for(int j=0;j<res.size();j++){
                    if(cur<=res.get(j)){
                        res.set(j,nums[i]);
                        break;
                    }
                }
            }
            if(res.size()==k) return true;
        }
        return false;
    }

    public static void main(String[] args){
        IncreasingTripletSubsequence inst = new IncreasingTripletSubsequence();
        int[] nums = {2,5,3,4,5};
        System.out.println(inst.increasingTriplet(nums));
    }
}
