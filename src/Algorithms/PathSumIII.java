/**
 * Created by yuhua on 24/10/16.
 */
public class PathSumIII {
    public int pathSum(TreeNode root, int sum) {
        if(root==null)
            return 0;
        int res = DFS(root,sum);
        //this recursion separate the case where cur is on path or cur is root
        res+= pathSum(root.left,sum);
        res+= pathSum(root.right,sum);
        return res;
    }

    //update path
    private int DFS(TreeNode cur, int residual){
        if(cur==null)
            return 0;

        int count=0;
        if(cur.val==residual)
            count+=1;
        count+=DFS(cur.left,residual-cur.val);
        count+=DFS(cur.right,residual-cur.val);
        return count;

    }
}
