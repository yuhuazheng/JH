
import javax.swing.text.html.HTMLDocument;
import java.util.*;

import static java.lang.System.in;

/**
 * Created by yuhua on 5/14/16.
 */
public class NumberOfIslandsII {

    public static void main(String[] args) {
        int m=3;
        int n=3;
        int[][] positions = {
                {0,1},
                {1,2},
                {2,1},
                {1,0},
                {0,2},
        {0,0},
        {1,1},
                };
        NumberOfIslandsII inst = new NumberOfIslandsII();
        List<Integer> res = inst.numIslands2(m,n,positions);
        for(int i : res){
            System.out.print(i);
            System.out.print(",");
        }
    }

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[] id = new int[m * n]; // 表示各个index对应的root

        List<Integer> res = new ArrayList<>();
        Arrays.fill(id, -1); // 初始化root为-1，用来标记water, 非-1表示land
        int count = 0; // 记录island的数量

        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        for (int i = 0; i < positions.length; i++) {
            count++;
            int index = positions[i][0] * n + positions[i][1];
            id[index] = index; // root初始化

            for (int j = 0; j < dirs.length; j++) {
                int x = positions[i][0] + dirs[j][0];
                int y = positions[i][1] + dirs[j][1];
                if (x >= 0 && x < m && y >= 0 && y < n && id[x * n + y] != -1) {
                    int root = root(id, x * n + y);

                    // 发现root不等的情况下，才union, 同时减小count
                    if (root != index) {
                        id[root] = index; //this will only change id[root], not union all points in this cluster
                        count--;
                    }
                }
            }
            res.add(count);
        }
        return res;
    }

    public int root(int[] id, int i) {
        while (i != id[i]) {
            id[i] = id[id[i]]; // 优化，为了减小树的高度. get to parent's parent
            i = id[i]; //move up to parent
        }
        return i;
    }
}
