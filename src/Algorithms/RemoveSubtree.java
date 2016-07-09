import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuhua on 09/07/16.
 */
public class RemoveSubtree {

    public void remove(TN[] tree, int t) {
        if (tree == null || tree.length == 0) return;
        int n = tree.length;
        int[] visited = new int[n]; //0:unvisited; 1: visited; -1: visited&&toremove

        //mark the target and the path from it to root
        TN cur = tree[t];
        visited[t] = -1;
        while (cur.parent != -1) { //-1 means the root of tree
            visited[cur.parent] = 1;
            cur = tree[cur.parent];
        }

        //scan the tree
        for (int i = 0; i < n; i++) {
            if (visited[i] != 0)
                continue;

            cur = tree[i];
            List<Integer> path = new ArrayList<>();
            while (visited[cur.idx] == 0) {
                path.add(i);
                cur = tree[cur.parent];
            }
            int mark = visited[cur.idx]; //1 or -1;
            while (!path.isEmpty()) {
                visited[path.get(0)] = mark;
                path.remove(0);
            }
        }

        //remove subtree
        for (int i = 0; i < n; i++) {
            if (visited[i] == -1)
                tree[i] = null;
        }
    }

    public static void main(String[] args) {
        TN n1 = new TN(0,-1);
        TN n2 = new TN(1,0);
        TN n3 = new TN(2,0);
        TN n4 = new TN(3,0);
        TN n5 = new TN(4,1);
        TN n6 = new TN(5,2);
        TN n7 = new TN(6,2);
        TN[] tree = new TN[7];
        tree[0]=n1;
        tree[1]=n2;
        tree[2]=n3;
        tree[3]=n4;
        tree[4]=n5;
        tree[5]=n6;
        tree[6]=n7;

        RemoveSubtree inst = new RemoveSubtree();
        inst.remove(tree,3);
        for(TN t: tree){
            if(t==null)
                System.out.println("null");
            else
                System.out.println(t.idx);
        }
    }
}

class TN{
    int idx;
    int parent;
    public TN(int i, int p){
        idx=i;
        parent=p;
    }
}