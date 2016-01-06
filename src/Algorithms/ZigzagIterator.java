package Algorithms;

import java.util.*;

/**
 * Created by yuhuazh on 9/30/2015.
 */
public class ZigzagIterator {

    List<Iterator<Integer>> iters = new ArrayList<Iterator<Integer>>();
    int count=0;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        if(!v1.isEmpty()) iters.add(v1.iterator());
        if(!v2.isEmpty()) iters.add(v2.iterator());
    }

    public int next() {
        int x = iters.get(count).next();
        if(!iters.get(count).hasNext()) iters.remove(count);
        else count++;

        if(iters.size()!=0) count%=iters.size(); //re-assign count back to head if it reached the end
        return x;
    }

    public boolean hasNext() {
        return !iters.isEmpty();
    }

    public static void main(String[] args){
        Integer[] v1 = {1,2};
        Integer[] v2 = {3,4,5,6};
        ZigzagIterator i = new ZigzagIterator(Arrays.asList(v1), Arrays.asList(v2));
        while (i.hasNext()){
            System.out.print(i.next());
            System.out.print(",");
        }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
}
