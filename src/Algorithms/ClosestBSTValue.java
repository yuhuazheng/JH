package Algorithms;

/**
 * Created by yuhua on 9/15/15.
 */
public class ClosestBSTValue {
    public int closestValue(TreeNode root, double target) {

        if(root.left==null && root.right==null) return root.val;
        int min = root.val;
        if(root.left!=null) {
            int l = closestValue(root.left, target);
            if (Math.abs(l - target) < Math.abs(min - target)) {
                min = l;
            }
        }
        if(root.right!=null) {
            int r = closestValue(root.right, target);
            if (Math.abs(r - target) < Math.abs(min - target)) {
                min = r;
            }
        }
        return min;
    }
}
