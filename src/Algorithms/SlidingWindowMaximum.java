package Algorithms;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Created by yuhua on 7/29/15.
 */
public class SlidingWindowMaximum {

    public static void main(String[] args){
        int[] nums = {1,-1};
        int k=1;
        System.out.println(maxSlidingWindow(nums,k).toString());
    }


    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null||k<=0) return new int[0];

       /* int[] res = new int[nums.length-k+1];
        Deque<Integer> q = new LinkedList<Integer>(); //first is the biggest.

        for(int i=0;i<k;i++){
            while(!q.isEmpty()&&nums[i]>=nums[q.peekLast()]){ //remove previous ones that smaller than nums[i]
                q.removeLast();
            }
            q.offerLast(i);
        }

        for(int i=k;i<nums.length;i++){
            res[i-k] = nums[q.peekFirst()];
            while(!q.isEmpty()&&nums[i]>=nums[q.peekLast()]){
                q.removeLast();
            }
            while(!q.isEmpty()&&q.peekFirst()<=i-k){ //remove element that outside the window
                q.removeFirst();
            }
            q.offerLast(i);
        }
        res[nums.length-k] = nums[q.pollFirst()];

        return res;*/

        int n = nums.length;
        int[] res = new int[n-k+1];
        PriorityQueue<Integer> h = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<n;i++){
            h.offer(nums[i]);
            if(i>=k)
                h.remove(nums[i-k]);
            if(i>=k-1)
            res[i+1-k]=h.peek();
        }
        return res;
    }
}
