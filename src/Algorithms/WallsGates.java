package Algorithms;

import java.util.Arrays;

/**
 * Created by yuhuazh on 10/7/2015.
 */
public class WallsGates {

    public static void main(String[] args){
        int INF=2147483647;
        int[][] rooms={
                {INF,  -1,  0,  INF},
                {INF, INF, INF,  -1},
                {INF,  -1, INF,  -1},
                {0,  -1, INF, INF}
                };
        WallsGates inst = new WallsGates();
        inst.wallsAndGates(rooms);
        for(int i=0;i<rooms.length;i++){
            System.out.println(Arrays.toString(rooms[i]));
        }
    }


    public void wallsAndGates(int[][] rooms) {
        int r=rooms.length;
        int c=rooms[0].length;
        int updated=-1;
        int step=0;

        while(updated!=0){
            step++;
            updated=0;
            for(int i=0;i<r;i++){
                for(int j=0;j<c;j++){
                    int v=rooms[i][j];
                    if(v==-1||v==0 || (v>0&&v<step)){
                        continue;
                    }
                    else if(reached(rooms,i,j,step-1)){
                        rooms[i][j]=step;
                        updated++;
                    }
                }
            }
        }
    }

    private boolean reached(int[][] rooms,int i, int j, int step){
        int[] offsetR={-1,1,0,0};
        int[] offsetC={0,0,-1,1};
        for(int k=0;k<4;k++){
            int s = i+offsetR[k];
            int t = j+offsetC[k];
            if(s<0||s>=rooms.length||t<0||t>=rooms[0].length) continue;
            if(rooms[s][t]==step) return true;
        }
        return false;
    }
}
