package Algorithms;

import java.util.Stack;

/**
 * Created by yuhua on 10/1/15.
 */
public class BSTUpsideDown {

    public static void main(String[] args){
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        n1.left=n2;
        BSTUpsideDown inst = new BSTUpsideDown();

        TreeNode r = inst.upsideDownBinaryTree(n1);
        System.out.println(r.val);
        //System.out.println(r.left.val);
        System.out.println(r.right.val);
    }

    public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode n=root, p=null, r=null;
        while(n!=null){
            TreeNode l=n.left;
            n.left=r;
            r=n.right;
            n.right=p;
            p=n;
            n=l;
        }
        return p;
    }
}
