import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuhuazh on 6/16/2016.
 */
public class Skyline {

    class HeightPoint{
        int x;
        int h;
        public HeightPoint(int idx, int ht){
            x=idx;
            h=ht;
        }
    }

    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        if(buildings==null||buildings.length==0||buildings[0].length==0) return res;



    }
}
