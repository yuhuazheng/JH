package Algorithms;

import java.util.*;

/**
 * Created by yuhua on 5/9/16.
 */
public class TopKFreqElements2 {
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

        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(new pqComparator());
        int i=0;
        for(Map.Entry<Integer,Integer> e: countMap.entrySet()){
            if(i<k)
                pq.offer(e);
            else{
                if(e.getValue()>pq.peek().getValue()){
                    pq.poll();
                    pq.offer(e);
                }
            }
            i++;
        }

        List<Integer> res = new ArrayList<>();
        while(!pq.isEmpty()){
            res.add(pq.poll().getKey());
        }
        return res;

    }

    class pqComparator implements Comparator<Map.Entry<Integer,Integer>>{
        public int compare(Map.Entry<Integer,Integer> e1,Map.Entry<Integer,Integer> e2){
            return e1.getValue()-e2.getValue();
        }
    }
}
