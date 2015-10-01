package Algorithms;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by yuhuazh on 9/30/2015.
 */
public class ZigzagIterator {
    Queue<Integer> q;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        int curRow=0;
        int curCol=0;
        int maxCol = Math.max(v1.size(),v2.size());
        q = new LinkedList<Integer>();
        boolean foundNext = true;

        while(curCol<maxCol){
            if((curRow==0&&curCol<v1.size()) || (curRow==1&&curCol<v2.size())){
                int v = curRow==0 ? v1.get(curCol): v2.get(curCol);
                q.offer(v);
            }

            curRow++;
            if(curRow==2){
                curRow=0;
                curCol++;
            }
        }
    }

    public int next() {

        return q.poll();
    }

    public boolean hasNext() {
        return !q.isEmpty();
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
