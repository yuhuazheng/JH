package Algorithms;

/**
 * Created by yuhuazh on 3/5/2016.
 */
public class BTLongestConsecutiveSequence {

    public int longestConsecutive(TreeNode root) {
        if(root==null) return 0;
        int[] maxlen = new int[1];
        maxlen[0]=1;

        helper(root.left, root.val,1,maxlen);
        helper(root.right,root.val,1,maxlen);
        return maxlen[0];
    }

    private void helper(TreeNode cur, int preValue, int curlen,int[] maxlen){
        if(cur==null){
            if(curlen>maxlen[0])
                maxlen[0]=curlen;
        }
        else if(cur.val==preValue+1){
            helper(cur.left,cur.val,curlen+1,maxlen);
            helper(cur.right,cur.val,curlen+1,maxlen);
        }
        else{
            if(curlen>maxlen[0])
                maxlen[0]=curlen;
            helper(cur.left,cur.val,1,maxlen);
            helper(cur.right,cur.val,1,maxlen);
        }
    }
}
