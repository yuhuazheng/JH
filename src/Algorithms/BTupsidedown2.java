package Algorithms;

/**
 * Created by yuhua on 10/1/15.
 */
public class BTupsidedown2 {
    public TreeNode UpsideDownBinaryTree(TreeNode root) {
        return dfsBottomUp(root, null);
    }
    private TreeNode dfsBottomUp(TreeNode p, TreeNode parent) {
        //boundary case to get the final new root
        if (p == null) return parent;

        //dfs recursively, will converage to boundary case and return the final new root
        TreeNode root = dfsBottomUp(p.left, p);

        //during recursion, connections are updated.
        p.left = (parent == null) ? parent : parent.right;
        p.right = parent;

        //root will go dfs til the final new root
        return root;
    }

}
