
/**
 * Created by yuhuazh on 10/2/2015.
 */
public class BSTInorderSuccessor {

    public static void main(String[] args){
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);
        n1.left=n2;
        n1.right=n3;

        BSTInorderSuccessor inst = new BSTInorderSuccessor();
        TreeNode res = inst.inorderSuccessor(n1,n2);
        System.out.print(res.val);
    }


    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(p.right!=null) return minNode(p.right);

        TreeNode parent=null;
        TreeNode cur = root;
        //find the closest parent that has bigger value than p
        //if p is left child, it will be immediate parent
        //if p is right child, it will trace back up to the closest left turn.
        while(cur.val!=p.val){
            if(cur.val>p.val){ //going left, update both parent and cur
                parent=cur;
                cur=cur.left;
            }
            else{
                cur=cur.right; //going right, hold parent, update cur
            }
        }
        return parent;

    }

    private TreeNode minNode(TreeNode root){
        TreeNode res=root;
        while(res.left!=null){
            res=res.left;
        }
        return res;
    }
}
