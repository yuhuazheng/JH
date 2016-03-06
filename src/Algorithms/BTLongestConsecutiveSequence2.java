package Algorithms;

/**
 * Created by yuhuazh on 3/5/2016.
 */
public class BTLongestConsecutiveSequence2 {
    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        return helper(root, 0, root.val - 1);
    }

    private int helper(TreeNode cur, int prelen, int preValue){
        if(cur==null) return prelen;
        int curlen = (cur.val==preValue+1)? prelen+1:1;
        return Math.max(curlen,Math.max(helper(cur.left,curlen,cur.val),helper(cur.right,curlen,cur.val)));
    }
}
