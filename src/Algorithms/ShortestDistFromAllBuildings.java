
import java.util.*;

/**
 * Created by yuhua on 5/15/16.
 */
public class ShortestDistFromAllBuildings {

    public int shortestDistance(int[][] grid) {
        int buildings = countBuildings(grid);
        int[][] dist = new int[grid.length][grid[0].length];
        int[][] reach = new int[grid.length][grid[0].length];


        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    bfs(grid, i, j, dist, reach);
                }
            }
        }

        int res = Integer.MAX_VALUE;
        boolean exist = false;
        for(int i = 0; i < dist.length; i++) {
            for(int j = 0; j < dist[0].length; j++) {
                if (grid[i][j] == 0 && reach[i][j] == buildings) {
                    exist = true;
                    res = Math.min(res, dist[i][j]);
                }
            }
        }

        return exist ? res : -1;
    }

    private int countBuildings(int[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    private void bfs(int[][] grid, int x, int y, int[][] dist, int[][] reach) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visit = new HashSet<>();
        int level = 0;
        queue.offer(x * cols + y);
        visit.add(x * cols + y);

        while(!queue.isEmpty()) {
            int len = queue.size();
            for(int p = 0; p < len; p++) {
                int head = queue.poll();
                int curX = head / cols, curY = head % cols;
                if (grid[curX][curY] == 0) {
                    dist[curX][curY] += level;
                    reach[curX][curY]++;
                }

                for(int i = 0; i < dir.length; i++) {
                    int newX = curX + dir[i][0], newY = curY + dir[i][1];
                    if (newX < 0 || newX >= rows || newY < 0 || newY >= cols) {
                        continue;
                    }
                    if (grid[newX][newY] == 1 || grid[newX][newY] == 2) {
                        continue;
                    }
                    if (visit.contains(newX * cols + newY)) {
                        continue;
                    }
                    queue.offer(newX * cols + newY);
                    visit.add(newX * cols + newY);
                }
            }

            level++;
        }
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
