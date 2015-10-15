package Algorithms;

import java.util.*;

/**
 * Created by yuhuazh on 10/13/2015.
 */
public class GraphValidTreeBFS {

    public static void main(String[] args){
        int[][] edges = {
                {0,1},
                {0,2},
                {1,2},
                {2,3},
                {2,4}
                };

        GraphValidTreeBFS inst = new GraphValidTreeBFS();
        System.out.println(inst.validTree(5,edges));
    }

    public boolean validTree(int n, int[][] edges) {
        if(n<0) return false;
        if(n<=1) return true;
        if(edges==null||edges.length==0 || edges[0].length==0) return false;

        List<Set<Integer>> map = new ArrayList<Set<Integer>>();
        boolean[] visited = new boolean[n];
        Stack<Integer> stk = new Stack<>();

        for(int i=0; i<n;i++){
            map.add(i,new HashSet<>());
        }

        for(int i=0; i<edges.length;i++){
            int start = edges[i][0];
            int end = edges[i][1];
            map.get(start).add(end);
            map.get(end).add(start);
        }

        //BFS detect cycle
        stk.add(0);
        while(!stk.isEmpty()){
            int cur = stk.pop();
            if(visited[cur]) return false;
            visited[cur]=true;
            for(int nb : map.get(cur)){
                //remove parent
                map.get(nb).remove(cur);
                stk.push(nb);
            }
        }

        //detect no-connection
        for(boolean b : visited){
            if(!b) return false;
        }

        return true;
    }
}
