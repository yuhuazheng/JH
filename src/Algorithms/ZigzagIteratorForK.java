package Algorithms;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by yuhuazh on 10/1/2015.
 */
public class ZigzagIteratorForK implements Iterator<Integer> {

        List<Iterator<Integer>> itlist;
        int turns;

        public ZigzagIteratorForK(List<Iterator<Integer>> list) {
            this.itlist = new LinkedList<Iterator<Integer>>();
            // ??????????
            for(Iterator<Integer> it : list){
                if(it.hasNext()){
                    itlist.add(it);
                }
            }
            turns = 0;
        }

        public Integer next() {
            if(!hasNext()){
                return 0;
            }
            Integer res = 0;
            // ?????????????
            int pos = turns % itlist.size();
            Iterator<Integer> curr = itlist.get(pos);
            res = curr.next();
            // ???????????????????
            if(!curr.hasNext()){
                itlist.remove(turns % itlist.size());
                // turns??????????
                turns = pos - 1;
            }
            turns++;
            return res;
        }

        public boolean hasNext() {
            return itlist.size() > 0;
        }
    }
