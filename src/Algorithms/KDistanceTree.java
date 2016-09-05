import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuhua on 04/09/16.
 */
public class KDistanceTree {
    public void goDown(TreeNode root, int k, List<Integer> res){
        if(root==null||k<0) return;
        if(k==0){
            res.add(root.val);
            return;
        }
        goDown(root.left,k-1,res);
        goDown(root.right,k-1,res);
    }

    public int distance(TreeNode root, TreeNode target, int k, List<Integer> res){
        if(root==null) return -1;
        if(root.val==target.val){
            goDown(root,k,res);
            return 0;
        }

        int distL = distance(root.left,target,k,res);
        if(distL!=-1){
            if(distL+1==k){
                res.add(root.val);
            }
            else{
                goDown(root.right,k-distL-2,res);
                return 1+distL;
            }
        }

        int distR = distance(root.right,target,k,res);
        if(distR!=-1){
            if(distR+1==k){
                res.add(root.val);
            }
            else{
                goDown(root.left,k-distR-2,res);
                return 1+distR;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        TreeNode root= new TreeNode(20);
        root.left=new TreeNode(9);
        root.right=new TreeNode(25);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(12);
        root.left.right.left=new TreeNode(10);
        root.right.left=new TreeNode(21);

        KDistanceTree inst = new KDistanceTree();
        int k=2;
        TreeNode target = root.left;
        List<Integer> res = new ArrayList<>();
        inst.distance(root,target,k,res);
        for(int i: res)
            System.out.print(i+", ");
    }
}
