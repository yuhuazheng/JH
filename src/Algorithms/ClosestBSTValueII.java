package Algorithms;

import java.util.*;

/**
 * Created by yuhua on 5/14/16.
 */
public class ClosestBSTValueII {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Set<Integer> values = new HashSet<>();
        PriorityQueue<Double> maxDiffHeap = new PriorityQueue<Double>(new Comparator<Double>(){
            @Override
            public int compare(Double d1, Double d2){
                return (int)(d2-d1);
            }
            });

        helper(root, target, k, maxDiffHeap,values);
        return new ArrayList<>(values);
    }

    private void helper(TreeNode root, double target, int k, PriorityQueue<Double> maxDiffHeap, Set<Integer> values){
        if(root==null) return;
        double diff = Math.abs(root.val-target);
        if(maxDiffHeap.size()<k){
            maxDiffHeap.offer(diff);
            values.add(root.val);
        }
        else if(diff<maxDiffHeap.peek()){//a closer value
            double toDel = maxDiffHeap.poll();
            if(!values.remove((int)(target+toDel)))
                values.remove((int)(target-toDel));
            maxDiffHeap.offer(diff);
            values.add(root.val);
        }
        else{
            if(root.val>target) helper(root.left,target,k,maxDiffHeap,values);
            else    helper(root.right,target,k,maxDiffHeap,values);
            return;
        }
        helper(root.left,target,k,maxDiffHeap,values);
        helper(root.right,target,k,maxDiffHeap,values);
    }
}
