package Algorithms;

/**
 * Created by yuhua on 3/27/16.
 */
public class LargestBSTSubtree {
    public int largestBSTSubtree(TreeNode root) {
        if(root==null) return 0;
        if(root.left==null&&root.right==null) return 1;

        int[] res = helper(root);
        return res[3];
    }

    private int[] helper(TreeNode root){
        int[] buf = new int[4];
        //buf[0]:-1 current root is not BST. buf[1]: min val; buf[2]: max val
        //buf[3]: max node# of sub BST
        if(root.left==null&&root.right==null){
            buf[0]=1;
            buf[1]=buf[2]=root.val;
            buf[3]=1;
            return buf;
        }

        if(root.left==null){
            buf[1]=root.val;
        }
        else {
            int[] l = helper(root.left);
            if (l[0] == -1 || (l[0]==1&&l[2]>root.val)) {
                buf[0] = -1;
                buf[3] = l[3];
            } else {
                buf[1] = l[1];
                buf[3] +=l[3];
            }
        }

        if(root.right==null){
            buf[2]=root.val;
        }
        else {
            int[] r = helper(root.right);
            if (buf[0]==-1|| r[0] == -1 || (r[0]==1&&r[1]<root.val)) {
                buf[0] = -1;
                buf[3] = Math.max(buf[3],r[3]);
            } else {
                buf[2] = r[2];
                buf[3]+= r[3];
            }
        }

        if(buf[0]>=0){
            buf[0]=1;
            buf[3]++; //count root itself
        }

        return buf;
    }
}
