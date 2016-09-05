import sun.reflect.generics.tree.Tree;

/**
 * Created by yuhua on 04/09/16.
 */
public class BSTInsertDelete {
    public TreeNode insert(TreeNode root, int v){
        //given root and insert a node with v
        if(root==null){
            return new TreeNode(v);
        }

        TreeNode cur = root;
        while(cur!=null){
            if(v<cur.val){
                if(cur.left==null){
                    cur.left = new TreeNode(v);
                    return root;
                }
                else{
                    cur=cur.left;
                }
            }
            else{
                if(cur.right==null){
                    cur.right=new TreeNode(v);
                    return root;
                }
                else{
                    cur=cur.right;
                }
            }
        }
        return root;
    }

    public TreeNode delete(TreeNode root, int v){
        if(root==null) return root;
        if(v<root.val)
            root.left = delete(root.left,v);
        else if(v>root.val)
            root.right = delete(root.right,v);
        else{
            //remove root
            if(root.left==null){
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }
            else{
                //replace root with min-of-right, then delete it
                TreeNode temp = findMin(root.right);
                root.val=temp.val;
                root.right=delete(root.right,temp.val);
            }
        }
        return root;
    }

    private TreeNode findMin(TreeNode root){
        if(root==null) return root;
        while(root.left!=null)
            root=root.left;
        return root;
    }

    public void printTree(TreeNode root){
        if(root==null) return;
        printTree(root.left);
        System.out.print(root.val+", ");
        printTree(root.right);
    }

    public static void main(String[] args) {
        BSTInsertDelete inst = new BSTInsertDelete();
        TreeNode r = null;
        r=inst.insert(r,10);
        r=inst.insert(r,6);
        r=inst.insert(r,13);
        r=inst.insert(r,4);
        r=inst.insert(r,12);
        inst.printTree(r);
        System.out.println();
        r=inst.delete(r,6);
        inst.printTree(r);
    }
}
