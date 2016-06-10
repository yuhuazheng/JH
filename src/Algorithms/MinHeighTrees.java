
import java.util.*;

/**
 * Created by yuhua on 3/27/16.
 */
public class MinHeighTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if(n<=0||edges==null||edges.length==0||edges[0].length==0) return res;
        if(n==1){
            res.add(0);
            return res;
        }

        HashMap<Integer,HashSet<Integer>> map = new HashMap<Integer,HashSet<Integer>>();
        HashSet<Integer> cand = new HashSet<>(); //to hold candidates for root
        HashSet<Integer> leaves = new HashSet<>(); //to hold current leaves, they should be removed from cand

        for(int i=0;i<n;i++){
            cand.add(i);
            map.put(i,new HashSet<>());
        }

        for(int[] curEdge : edges){
            int i1=curEdge[0];
            int i2=curEdge[1];
            map.get(i1).add(i2);
            map.get(i2).add(i1);
        }


        for(int k:map.keySet()){
            if(map.get(k).size()==0){
                map.remove(k);
                cand.remove(k);
            }
            if(map.get(k).size()==1){
                leaves.add(k);
            }
        }

        while(cand.size()>2){
            HashSet<Integer> newLeaves = new HashSet<>();
            for(int n1:leaves){
                cand.remove(n1); //remove node
                for(int n2:map.get(n1)){
                    map.get(n1).remove(n2);//remove edges
                    map.get(n2).remove(n1);
                    if(map.get(n2).size()==1) newLeaves.add(n2);
                }
                map.remove(n1);
            }
            leaves=newLeaves;
        }
        for(int r : cand){
            res.add(r);
        }
        return res;
    }
}
