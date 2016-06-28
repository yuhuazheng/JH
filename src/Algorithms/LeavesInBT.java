import java.util.*;

/**
 * Created by yuhuazh on 6/24/2016.
 */
public class LeavesInBT {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Set<TreeNode> leaveSet = new HashSet<>();
        while (!leaveSet.contains(root)) {
            List<Integer> vals = BFSLeaves(root,leaveSet);
            res.add(vals);
        }

        return res;
    }

    private List<Integer> BFSLeaves(TreeNode root, Set<TreeNode> leaveSet){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        List<Integer> leaves = new ArrayList<>();

        int count=1;
        int number=0;
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            number++;
            if( !leaveSet.contains(cur)
                &&(cur.left==null||leaveSet.contains(cur.left))
                && (cur.right==null||leaveSet.contains(cur.right))
                    ){
                leaves.add(0, cur.val);
                leaveSet.add(cur);
            }
            else{
                if(cur.left!=null)  q.offer(cur.left);
                if(cur.right!=null)  q.offer(cur.right);
            }
            if(number==count){ //finish cur level
                count=q.size();
                number=0;
            }
        }
        return leaves;
    }

    public static void main(String[] args) {
        TreeNode n1= new TreeNode(1);
        TreeNode n2= new TreeNode(2);
        TreeNode n3= new TreeNode(3);
        TreeNode n4= new TreeNode(4);
        TreeNode n5= new TreeNode(5);
        n1.left=n2;
        n1.right=n3;
        n2.left=n4;
        n2.right=n5;
        LeavesInBT inst = new LeavesInBT();
        List<List<Integer>> res = inst.findLeaves(n1);
        for(List<Integer> l:res){
            System.out.println(l);
        }
    }
}
