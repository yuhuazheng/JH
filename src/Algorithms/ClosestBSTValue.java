package Algorithms;

/**
 * Created by yuhua on 9/15/15.
 */
public class ClosestBSTValue {
    public int closestValue(TreeNode root, double target) {
        //what is the ideal closest value? ==target
        //so this problem actually is looking for target
        //binary search
        if(root.left==null && root.right==null) return root.val;
        int min = root.val;
        double diff;
        TreeNode cur = root;
        while(cur!=null){
            diff = (double)cur.val-target;
            if(diff==0) return cur.val;
            if(Math.abs(diff)<Math.abs(min-target)) min=cur.val;
            if(diff>0){
                cur=cur.left;
            }
            else{
                cur=cur.right;
            }
        }
        return min;
    }
}
