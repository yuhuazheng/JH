package Algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by yuhua on 5/9/16.
 */
public class TopKFreqElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for(int n: nums){
            if(!countMap.containsKey(n)){
                countMap.put(n,1);
            }
            else{
                countMap.put(n,countMap.get(n)+1);
            }
        }

        HashMap<Integer, List<Integer>> reverseMap = new HashMap<>();
        for(int val: countMap.keySet()){
            int count = countMap.get(val);
            List<Integer> temp = new ArrayList<>();
            if(reverseMap.containsKey(count))
                temp = reverseMap.get(count);
            temp.add(val);
            reverseMap.put(count,temp);
        }

        List<Integer> res = new ArrayList<>();
        for(int i=nums.length;i>=0;i--){
            if(!reverseMap.containsKey(i)){
                continue;
            }
            List<Integer> toAdd = reverseMap.get(i);
            if(toAdd.size()>(k-res.size()))
                toAdd = toAdd.subList(0,k-res.size());
            res.addAll(toAdd);
            if(res.size()==k)
                break;
        }

        return res;

    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k=2;
        TopKFreqElements inst = new TopKFreqElements();
        List<Integer> res = inst.topKFrequent(nums,k);
        for(int i: res){
            System.out.print(i);
            System.out.print(",");
        }
    }
}
