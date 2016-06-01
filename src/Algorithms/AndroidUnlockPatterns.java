import java.util.*;

/**
 * Created by yuhua on 31/05/16.
 */
public class AndroidUnlockPatterns {

    public int numberOfPatterns(int m, int n) {
        if(n==0) return 0;
        int[] count= new int[1];
        int[][] mp = new int[10][10];
        mp[1][3] = mp[3][1]=2;
        mp[4][6] = mp[6][4]=5;
        mp[7][9] = mp[9][7]=8;
        mp[1][7] = mp[7][1]=4;
        mp[2][8] = mp[8][2]=5;
        mp[3][9] = mp[9][3]=6;
        mp[1][9] = mp[9][1]= mp[3][7] = mp[7][3] = 5;

        helper(m,n,new ArrayList<Integer>(), mp, count);
        return count[0];
    }

    private void helper(int m, int n, List<Integer> item, int[][] mp,int[] count){
        if(!item.isEmpty()){
            if(item.size()>=m&&item.size()<=n) {
                count[0]++;
            }
            else if(item.size()>n){
                return;
            }
        }

        //if item.isempy, item.size()<m, and between m and n, do DFS
        for(int v=1;v<=9;v++){
            if(item.isEmpty()){
                item.add(v);
                helper(m,n,item,mp,count);
                item.remove(item.size()-1);
            }
            else {
                if (item.contains(v)) {
                    continue; //all v must be distinct
                }

                int pre = item.get(item.size() - 1);
                if (!isValid(pre, v, item,mp)) { //a valid step
                    continue;
                }
                item.add(v);
                helper(m, n, item, mp, count);
                item.remove(item.size() - 1);
            }
        }
    }

    private boolean isValid(int i, int j, List<Integer> item, int[][] mp){
        if(mp[i][j]==0|| item.contains(mp[i][j])) return true;
        return false;
    }
}
