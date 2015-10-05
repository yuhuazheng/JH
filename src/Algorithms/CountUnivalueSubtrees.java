package Algorithms;

/**
 * Created by yuhuazh on 10/4/2015.
 */
public class CountUnivalueSubtrees {

    public static void main(String[] args){
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(5);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(5);
        n1.left=n2;
        n1.right=n3;
        n2.left=n4;
        n2.right=n5;
        n3.right=n6;

        CountUnivalueSubtrees inst = new CountUnivalueSubtrees();
        System.out.println(inst.countUnivalSubtrees(n1));
    }

    public int countUnivalSubtrees(TreeNode root) {
        if(root==null) return 0;
        if(root.left==null && root.right==null) return 1;
        int[] res= new int[1];
        helper(root, res);
        return res[0];
    }

    //subtree of root inclusive is univalue or not
    private boolean helper(TreeNode root,int[] res){
        if(root.left==null && root.right==null){
            res[0]+=1;
            return true;
        }

        boolean equalLeft=false;
        boolean equalRight=false;

        if(root.left==null || (root.left!=null && helper(root.left,res) && root.val==root.left.val)){
            equalLeft = true;
        }

        if(root.right==null || (root.right!=null && helper(root.right,res) && root.val==root.right.val)){
            equalRight = true;
        }

        if(equalLeft&&equalRight) {
            res[0] += 1;
            return true;
        }

        return false;
    }
}
