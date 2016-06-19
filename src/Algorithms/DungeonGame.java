import java.util.Arrays;

/**
 * Created by yuhua on 18/06/16.
 */
public class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon==null||dungeon.length==0||dungeon[0].length==0) return 0;

        int m=dungeon.length;
        int n=dungeon[0].length;
        int[][] minHealth = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(minHealth[i],1); //1 is minimal to keep alive
        }
        if(dungeon[m-1][n-1]<0){
            minHealth[m-1][n-1]=1-dungeon[m-1][n-1];
        }

        //reversely dp
        for(int j=n-2;j>=0;j--){
            int fromRight = Math.max(0, minHealth[m-1][j + 1]- dungeon[m-1][j]);
            minHealth[m-1][j] = Math.max(minHealth[m-1][j], fromRight);
        }

        for(int i=m-2;i>=0;i--){
            int fromBottom = Math.max(0, minHealth[i + 1][n-1] - dungeon[i][n-1]);
            minHealth[i][n-1] = Math.max(minHealth[i][n-1], fromBottom);
        }

        for(int i=m-2;i>=0;i--){
            for(int j=n-2;j>=0;j--){
                int fromRight = Math.max(0, minHealth[i][j + 1]- dungeon[i][j]);
                int fromBottom = Math.max(0, minHealth[i + 1][j] - dungeon[i][j]);
                minHealth[i][j] = Math.max(minHealth[i][j], Math.min(fromRight,fromBottom));
            }
        }

        return minHealth[0][0];
    }

    public static void main(String[] args) {
        int[][] dungeon = {{2},{1}};
        DungeonGame inst = new DungeonGame();
        System.out.println(inst.calculateMinimumHP(dungeon));
    }
}
