/**
 * Created by yuhua on 18/06/16.
 */
public class BombEnemy {
    public int maxKilledEnemies(char[][] grid) {
        if(grid==null||grid.length==0||grid[0].length==0) return 0;

        int m=grid.length;
        int n=grid[0].length;
        int[][] left = new int[m][n];
        for(int i=0;i<m;i++){
            int count=0;
            for(int j=0;j<n;j++){
                char c = grid[i][j];
                if(c=='E'){
                    count++;
                }
                else if(c=='W'){
                    count=0;
                }
                else{
                    left[i][j]=count;
                }
            }
        }

        int[][] right = new int[m][n];
        for(int i=0;i<m;i++){
            int count=0;
            for(int j=n-1;j>=0;j--){
                char c = grid[i][j];
                if(c=='E'){
                    count++;
                }
                else if(c=='W'){
                    count=0;
                }
                else{
                    right[i][j]=count;
                }
            }
        }

        int[][] top = new int[m][n];
        for(int j=0;j<n;j++){
            int count=0;
            for(int i=0;i<m;i++){
                char c = grid[i][j];
                if(c=='E'){
                    count++;
                }
                else if(c=='W'){
                    count=0;
                }
                else{
                    top[i][j]=count;
                }
            }
        }

        int[][] bottom = new int[m][n];
        for(int j=0;j<n;j++){
            int count=0;
            for(int i=m-1;i>=0;i--){
                char c = grid[i][j];
                if(c=='E'){
                    count++;
                }
                else if(c=='W'){
                    count=0;
                }
                else{
                    bottom[i][j]=count;
                }
            }
        }

        int max=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                max=Math.max(max,left[i][j]+right[i][j]+top[i][j]+bottom[i][j]);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        char[][] grid ={
                {'0', 'E', '0', '0'},
                {'E', '0', 'W', 'E'},
                {'0', 'E', '0', '0'},
        };
        BombEnemy inst = new BombEnemy();
        System.out.println(inst.maxKilledEnemies(grid));
    }
}
