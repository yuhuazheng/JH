package Algorithms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

/**
 * Created by yuhua on 1/1/16.
 */
public class ComponentsCount {
    public static void main(String[] args) {
        ComponentsCount inst = new ComponentsCount();
        int[][] edges = {
                {0,1},
                {0,2},
                {2,5},
                {3,4},
                {3,5}
        };
        int n = 6;
        System.out.println(inst.countComponents(n, edges));
    }

    public int countComponents(int n, int[][] edges) {
            unionFind uf = new unionFind(n);
            for (int[] edge : edges) {
                if (!uf.isConnected(edge[0], edge[1])) {
                    uf.union(edge[0], edge[1]);
                }
            }
            return uf.findCount();
        }

    public class unionFind{
            int[] ids; //to keep the parent node
            int count;

            public unionFind(int num) {
                this.ids = new int[num];
                for (int i=0; i<num; i++) {
                    ids[i] = i;
                }
                this.count = num;
            }

            public int find(int i) {
                return ids[i];
            }

            public void union(int i1, int i2) {
                int id1 = find(i1);
                int id2 = find(i2);
                if (id1 != id2) {
                    for (int i=0; i<ids.length; i++) {
                        if (ids[i] == id2) {
                            ids[i] = id1;
                        }
                    }
                    count--;
                }
            }

            public boolean isConnected(int i1, int i2) {
                return find(i1)==find(i2);
            }

            public int findCount() {
                return count;
            }
        }
}
