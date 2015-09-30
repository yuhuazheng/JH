package Algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuhuazh on 9/17/2015.
 */
public class BTPaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        if(root==null) return res;
        List<String> item = new ArrayList<String>();
        explorePath(root,item,res);
        return res;
    }

    private void explorePath(TreeNode root,List<String> item, List<String> res){
        //add to path
        item.add(Integer.toString(root.val));

        //path ends
        if(root.left==null && root.right==null){
            StringBuilder onePath = new StringBuilder();
            onePath.append(item.get(0));
            for(int i=1;i<item.size();i++){
                onePath.append("->");
                onePath.append(item.get(i));
            }
            res.add(onePath.toString());
        }
        //path extends
        if(root.left!=null){
            explorePath(root.left, item, res);
        }
        if(root.right!=null){
            explorePath(root.right,item,res);
        }

        //path back propagate
        item.remove(item.size()-1);
    }
}
