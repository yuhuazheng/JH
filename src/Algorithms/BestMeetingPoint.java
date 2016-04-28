package Algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuhuazh on 4/24/2016.
 */
public class BestMeetingPoint {
    public int minTotalDistance(int[][] grid) {
        List<Integer> Xs = new ArrayList<>();
        List<Integer> Ys = new ArrayList<>();

        //get Ys
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]>0){
                    Ys.add(i);
                }
            }
        }

        //get Ys
        for(int j=0;j<grid[0].length;j++){
            for(int i=0;i<grid.length;i++){
                if(grid[i][j]>0){
                    Xs.add(j);
                }
            }
        }
        //x y are independent

        return MinDistance1D(Xs)+MinDistance1D(Ys);
    }

    //1d, the total min distance is sum to the median point
    //and 2 points can compute it
    private int MinDistance1D(List<Integer> ps){
        int sum=0;
        int i=0;
        int j=ps.size()-1;
        while(i<j){
            sum+=Math.abs(ps.get(j)-ps.get(i));
            i++;
            j--;
        }
        return sum;
    }
}
