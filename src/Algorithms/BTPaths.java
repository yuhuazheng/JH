import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuhuazh on 9/17/2015.
 */
public class BTPaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        helper(root,new ArrayList<String>(),res);
        return res;
    }

    private void helper(TreeNode root,List<String> item, List<String> res){
        if(root==null) return;

        //add current value; need a backtacking then
        item.add(Integer.toString(root.val));

        if(root.left==null&&root.right==null){

            StringBuilder sb = new StringBuilder();
            for(int i=0;i<item.size()-1;i++){
                sb.append(item.get(i));
                sb.append("->");
            }
            sb.append(item.get(item.size()-1));
            res.add(sb.toString());
        }
        else{
            if(root.left!=null)
                helper(root.left,item,res);
            if(root.right!=null)
                helper(root.right,item,res);
        }

        //backtracking
        item.remove(item.size()-1);
        return;
    }
}
