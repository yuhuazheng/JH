import java.util.Stack;

/**
 * Created by yuhua on 10/1/15.
 */
public class BTupsidedown2 {
    /*public TreeNode UpsideDownBinaryTree(TreeNode root) {
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
    }*/

    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root==null) return null;
        Stack<TreeNode> stk = new Stack<>();
        TreeNode cur=root;
        while(cur!=null){
            stk.push(cur);
            cur=cur.left;
        }
        TreeNode root2 = stk.pop();
        TreeNode pre = root2;
        while(!stk.isEmpty()){
            cur=stk.pop();
            cur.left = null;
            pre.left = cur.right;
            cur.right = null;
            pre.right = cur;
            pre= pre.right;
        }
        return root2;
    }


    public static void main(String[] args) {
        TreeNode r1= new TreeNode(1);
        TreeNode r2 = new TreeNode(2);
        r1.left=r2;
        BTupsidedown2 inst = new BTupsidedown2();
        TreeNode res = inst.upsideDownBinaryTree(r1);
    }
}
