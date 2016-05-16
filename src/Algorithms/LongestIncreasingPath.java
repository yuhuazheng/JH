package Algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuhua on 5/15/16.
 */
public class LongestIncreasingPath {

        int []dx = { 1 , -1, 0 , 0  };
        int []dy = { 0 , 0 , 1 , -1 };
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] dis = new int [m][n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, dfs( i, j, m, n, matrix, dis));
            }
        }
        return ans;
    }

    int dfs(int x, int y, int m,int n,int[][] matrix, int[][] dis) {
        if (dis[x][y] != 0) return dis[x][y];

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < m && ny < n && matrix[nx][ny] > matrix[x][y]) {
                dis[x][y] = Math.max(dis[x][y], dfs(nx, ny, m, n, matrix, dis));
            }
        }
        return ++dis[x][y];
    }

    public static void main(String[] args) {
        int[][] nums = {
                {3,4,5},
                {3,2,6},
                {2,2,1},
                };
        LongestIncreasingPath inst = new LongestIncreasingPath();
        int res = inst.longestIncreasingPath(nums);
        System.out.println(res);
    }
}
