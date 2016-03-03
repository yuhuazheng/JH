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
        TreeNode cur=root, p=null, preR=null, ntL=null;
        while(cur!=null){
            ntL=cur.left; //store next left
            cur.left=preR;//previous level right becomes new left
            preR=cur.right;//preR is free now, assigned with curent right for next round
            cur.right=p; //parent becomes new right
            p=cur;//move down one level
            cur=ntL;
        }
        return p;
    }
}
