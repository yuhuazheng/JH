import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by yuhua on 11/06/16.
 */
public class LineReflection {

    public boolean isReflected(int[][] points) {
        if (points == null || points.length == 0 || points[0].length == 0) return true;

        HashMap<Integer, List<Integer>> mp = new HashMap<>();
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            if (!mp.containsKey(y)) {
                mp.put(y, new ArrayList<>());
            }
            mp.get(y).add(x);
            minX = Math.min(minX, x);
            maxX = Math.max(maxX, x);
        }
        int middleInteger = (minX + maxX) / 2;
        double middleFloat = (minX+maxX)%2==0?0.0:0.5;
        middleFloat = middleInteger<0?-middleFloat:middleFloat;
        for (int k : mp.keySet()) {
            List<Integer> vs = mp.get(k);
            int count=0;
            double sum = 0;
            for (int v : vs) {
                if(middleFloat==0.0 && v==middleInteger) //point on middle line, skip
                    continue;
                count++;
                sum += middleInteger+middleFloat - v;
            }
            if (count%2!=0 || Math.abs(sum) > 0.0001)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] points = {
                {0,0},
                {1,0},
                {3,0},
        };
        LineReflection inst = new LineReflection();
        System.out.println(inst.isReflected(points));
    }
}
