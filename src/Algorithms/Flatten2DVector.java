import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by yuhua on 25/05/16.
 */
public class Flatten2DVector implements Iterator<Integer> {

        List<Iterator<Integer>> itList = new ArrayList<>();

        public Flatten2DVector(List<List<Integer>> vec2d) {
            for(List<Integer> vec1d : vec2d){
                itList.add(vec1d.iterator());
            }
        }

        @Override
        public Integer next() {
            int v = itList.get(0).next();
            return v;
        }

        @Override
        public boolean hasNext() {
            if(itList.isEmpty()) return false;
            while(!itList.isEmpty() && !itList.get(0).hasNext()){
                itList.remove(0);
            }
            return !itList.isEmpty();
        }
}
