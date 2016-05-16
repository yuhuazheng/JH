package Algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by yuhua on 5/15/16.
 */
public class ShortestDistFromAllBuildings {

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int shortestDistance(int[][] grid) {
        if(grid==null||grid.length==0||grid[0].length==0 ||(grid.length==1&&grid[0].length==1) ) return -1;
        int m=grid.length;
        int n=grid[0].length;

        //find all building locations
        List<Integer> buildR = new ArrayList<>();
        List<Integer> buildC = new ArrayList<>();
        HashSet<Integer> obstacles = new HashSet<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int idx = i*n+j;
                if(grid[i][j]==1){
                    buildR.add(i);
                    buildC.add(j);
                    obstacles.add(idx);
                }
                if(grid[i][j]==2)
                    obstacles.add(idx);
            }
        }

        int[][] res = new int[m][n];
        int minD= 0;
        for(int k=0;k<buildR.size();k++){
            int r=buildR.get(k);
            int c=buildC.get(k);
            int[][] buff = bfs(r,c,m,n,obstacles);
            minD=merge(res,buff);
        }
        return minD==Integer.MAX_VALUE?-1:minD;
    }

    private int merge(int[][] res, int[][] buff){
        int minD=Integer.MAX_VALUE;
        for(int i=0;i<res.length;i++){
            for(int j=0;j<res[0].length;j++){
                if(buff[i][j]==Integer.MAX_VALUE || res[i][j]==Integer.MAX_VALUE) {
                    res[i][j]=Integer.MAX_VALUE;
                }
                else {
                    res[i][j] += buff[i][j];
                }
                minD=Math.min(minD,res[i][j]);
            }
        }
        return minD;
    }


    private int[][] bfs(int r,int c,int m, int n, HashSet<Integer> obstacles) {
        boolean[][] visited = new boolean[m][n];
        int[][] buff = new int[m][n];
        List<Integer> nextR = new ArrayList<>();
        List<Integer> nextC = new ArrayList<>();

        buff[r][c] = Integer.MAX_VALUE;
        visited[r][c] = true;
        nextR.add(r);
        nextC.add(c);
        int dist=1;
        int count=1;

        while(!nextR.isEmpty()){
            int curr = nextR.get(0);
            nextR.remove(0);
            int curc = nextC.get(0);
            nextC.remove(0);
            for (int k = 0; k < 4; k++) {
                int ntr = curr+dx[k];
                int ntc = curc+dy[k];
                int ntIdx = ntr*n+ntc;
                if (ntr >= 0 && ntr < m && ntc >= 0 && ntc < n && !visited[ntr][ntc]) {
                    visited[ntr][ntc]=true;
                    if (obstacles.contains(ntIdx))
                        buff[ntr][ntc] = Integer.MAX_VALUE;
                    else{
                        buff[ntr][ntc] = dist;
                        nextR.add(ntr);
                        nextC.add(ntc);
                    }

                }
            }
            count--;
            if(count==0) {//this level is finished
                count = nextR.size();
                dist++;
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j])
                    buff[i][j]=Integer.MAX_VALUE;
            }
        }

        return buff;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0,2,1},
                {1,0,2},
                {0,1,0},
                };
        ShortestDistFromAllBuildings inst = new ShortestDistFromAllBuildings();
        int res = inst.shortestDistance(grid);
        System.out.println(res);
    }

}
