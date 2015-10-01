package Algorithms;

import java.util.*;

/**
 * Created by yuhuazh on 9/30/2015.
 */
public class ZigzagIterator {
    Iterator<Integer> it1;
    Iterator<Integer> it2;
    int turn;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        if(!v1.isEmpty()) it1=v1.iterator();
        if(!v2.isEmpty()) it2=v2.iterator();
        turn = 0;
    }

    public int next() {
        if(!hasNext()) return 0;
        turn++;
        // ??????????????????????????????????
        // ???????????????????????
        if((turn % 2 == 1 && it1.hasNext()) || (!it2.hasNext())){
            return it1.next();
            // ??????????????????????????????????
            // ???????????????????????
        } else if((turn % 2 == 0 && it2.hasNext()) || (!it1.hasNext())){
            return it2.next();
        }
        return 0;
    }

    public boolean hasNext() {
        return it1.hasNext()||it2.hasNext();
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
