package Algorithms;

import java.util.HashMap;

/**
 * Created by yuhuazh on 2/28/2016.
 */
public class TwoSumIII {
    HashMap<Integer,Integer> nums = new HashMap<Integer,Integer>();

    public void add(int number) {
        if(nums.containsKey(number)){
            nums.put(number,nums.get(number)+1);
        }
        else{
            nums.put(number,1);
        }
    }

    public boolean find(int target) {
        for (int i : nums.keySet()) {
            if (nums.containsKey(target-i)) {
                if (target - i != i) return true;
                else if (nums.get(i) >= 2) return true;
            }
        }
        return false;
    }
}
