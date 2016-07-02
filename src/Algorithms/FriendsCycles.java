
/**
 * Created by yuhuazh on 7/1/2016.
 */
import java.io.*;
import java.util.*;

public class FriendsCycles {

         public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
            Scanner scan = new Scanner(System.in);
            int n = scan.nextInt();
             scan.nextLine();
            char[][] grid = new char[n][n];
            int i=0;
            while(i<n){
                String str = scan.nextLine();
                char[] chs = str.toCharArray();
                grid[i]=chs;
                i++;
            }
             FriendsCycles inst = new FriendsCycles();
            System.out.println(inst.numIslands(grid));
        }

        public int numIslands(char[][] grid) {
            if(grid==null|| grid.length<1 || grid[0].length<1){
                return 0;
            }
            int m=grid.length;
            int n=grid[0].length;
            boolean[][] visited = new boolean[m][n];
            int count=0;
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(grid[i][j]=='Y' && !visited[i][j]){
                        count++;
                    }
                    floodfill(i,j,grid,visited);
                }
            }
            return count;
        }

        private void floodfill(int i, int j, char[][] grid, boolean[][] visited){
            int m=grid.length;
            int n=grid[0].length;
            if(i<0 || j<0 || i>=m || j>=n){
                return;
            }
            if(visited[i][j]){
                return;
            }
            visited[i][j]=true;
            if(grid[i][j]=='N'){
                return;
            }
            floodfill(i-1,j,grid,visited);
            floodfill(i+1,j,grid,visited);
            floodfill(i,j-1,grid,visited);
            floodfill(i,j+1,grid,visited);
            return;
        }

}
