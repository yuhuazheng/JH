import java.util.*;

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

        PriorityQueue<HeightPoint> buildingQ = new PriorityQueue<>(new Comparator<HeightPoint>(){
                @Override
                public int compare(HeightPoint p1, HeightPoint p2){
                    return p1.x==p2.x? p1.h-p2.h: p1.x-p2.x;
                }
            });
        for(int i=0;i<buildings.length;i++){
            int[] curB = buildings[i];
            HeightPoint curL = new HeightPoint(curB[0],-curB[2]);
            HeightPoint curR = new HeightPoint(curB[1],curB[2]); //left<0; right>0
            buildingQ.offer(curL);
            buildingQ.offer(curR);
        }

        PriorityQueue<Integer> heightQ = new PriorityQueue<>(Collections.reverseOrder()); //max heap
        heightQ.offer(0);
        int preHeight=0;
        while(!buildingQ.isEmpty()){
            HeightPoint cur = buildingQ.poll();
            if(cur.h<0){
                heightQ.offer(Math.abs(cur.h));
            }
            else {
                heightQ.remove(Math.abs(cur.h));
            }

            int curHeight = heightQ.peek();
            if(preHeight!=curHeight){
                int[] p ={cur.x,curHeight};
                res.add(p);
                preHeight=curHeight;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        Skyline inst = new Skyline();
        int[][] buildings = { {0,1,3} };
        List<int[]> res = inst.getSkyline(buildings);
        for(int[] p : res){
            System.out.println(Arrays.toString(p));
        }
    }
}
