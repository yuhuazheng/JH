package Algorithms;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yuhua on 9/23/15.
 */
public class ShortestPath2DMap {
    public int findShortestPath(char[][] map, int startR, int startC, int endR, int endC){
        if(map==null||map.length==0||map[0].length==0) return -1;

        point start= new point(startR,startC);
        point end= new point(endR,endC);
        int step=0;
        Queue<point> curCandidates = new LinkedList<>();
        curCandidates.offer(start);
        Queue<point> nextCandidates = new LinkedList<>();

        while(!curCandidates.isEmpty()){
            point cur = curCandidates.poll();
            if (cur.r==end.r&& cur.c==end.c) return step;

            //check for neighbors
            for(int i=-1;i<=1;i+=2){
                for(int j=-1;j<=1;j+=2){
                    int nextR=cur.r+i;
                    int nextC=cur.c+j;
                    if(nextR<0||nextC<0||nextR>=map.length||nextC>=map[0].length) continue;
                    if(map[nextR][nextC]=='x') continue;
                    nextCandidates.add(new point(nextR,nextC));
                }
            }
            //update candidates for next step
            if(curCandidates.isEmpty()){
                curCandidates=nextCandidates;
                nextCandidates = new LinkedList<>();
                step++;
            }
        }
        return -1;

    }

    class point{
        int r;
        int c;
        public point(int y, int x){
            r=y;
            c=x;
        }
    }

}
