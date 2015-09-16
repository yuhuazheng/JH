package Algorithms;

/**
 * Created by yuhuazh on 9/8/2015.
 */
public class LCABT {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null||root==p||root==q) return root;
        TreeNode l = lowestCommonAncestor(root.left,p,q);
        TreeNode r = lowestCommonAncestor(root.right,p,q);
        if(l!=null&&r!=null) return root;
        return l!=null?l:r;
    }
}
