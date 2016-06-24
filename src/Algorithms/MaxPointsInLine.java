import java.util.HashMap;

/**
 * Created by yuhuazh on 6/23/2016.
 */
public class MaxPointsInLine {

    public int maxPoints(Point[] points) {
        if(points==null || points.length<1){
            return 0;
        }
        if(points.length<=2){
            return points.length;
        }
        int maxPts = 0;
        for(int i=0; i<points.length; i++) {
            int nMax = 0, nSame = 0, nInf = 0;
            HashMap<Double,Integer> comSlopes = new HashMap<>();

            for(int j=i+1; j<points.length; j++) {
                if(points[j].x==points[i].x) {
                    if(points[j].y==points[i].y)
                        nSame++;
                    else
                        nInf++;
                    continue;
                }
                double slope = (double)(points[j].y-points[i].y)/(double)(points[j].x-points[i].x);
                if(slope==-0.0) slope=0.0;
                if(!comSlopes.containsKey(slope)){
                    comSlopes.put(slope,1);
                }
                else{
                    comSlopes.put(slope,comSlopes.get(slope)+1);
                }
                nMax = Math.max(nMax, comSlopes.get(slope));
            }

            nMax = Math.max(nMax, nInf)+nSame+1; //ith point itself
            maxPts = Math.max(maxPts,nMax);
        }
        return maxPts;
    }

    public static void main(String[] args) {
        Point p1 = new Point(2,3);
        Point p2 = new Point(3,3);
        Point p3 = new Point(-5,3);
        Point[] points = new Point[3];
        points[0]=p1;
        points[1]=p2;
        points[2]=p3;
        MaxPointsInLine inst = new MaxPointsInLine();
        System.out.print(inst.maxPoints(points));
    }
}
