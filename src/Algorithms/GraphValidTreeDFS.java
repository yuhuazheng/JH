package Algorithms;

import java.util.*;

/**
 * Created by yuhuazh on 10/13/2015.
 */
public class GraphValidTreeDFS {
   /*
    public static void main(String[] args){
        int[][] edges = {
                {0,1},
                {0,2},
                {1,2},
                {2,3},
                {2,4}
        };

        GraphValidTreeDFS inst = new GraphValidTreeDFS();
        System.out.println(inst.validTree(5,edges));
    }

    public boolean validTree(int n, int[][] edges) {
        if(n<0) return false;
        if(n<=1) return true;
        if(edges==null||edges.length==0 || edges[0].length==0) return false;

        List<Set<Integer>> map = new ArrayList<Set<Integer>>();
        boolean[] visited = new boolean[n];

        for(int i=0; i<n;i++){
            map.add(i,new HashSet<>());
        }

        for(int i=0; i<edges.length;i++){
            int start = edges[i][0];
            int end = edges[i][1];
            map.get(start).add(end);
            map.get(end).add(start);
        }

        //DFS detect cycle
        boolean[] onPath = new boolean[n];
        if(hasCycle(map,0,-1,onPath,visited))
            return false;

        //detect no-connection
        for(boolean b : visited){
            if(!b) return false;
        }

        return true;
    }

    //true if has cycle
    private boolean hasCycle(List<Set<Integer>> map, int cur, int parent, boolean[] onPath, boolean[] visited){
        if(onPath[cur]) return true;
        onPath[cur] = visited[cur] = true;
        for(int nb : map.get(cur)){
            if(nb!=parent && hasCycle(map,nb,cur,onPath,visited))
                return true;
        }
        onPath[cur]=false;
        return false;
    }
    */
}
