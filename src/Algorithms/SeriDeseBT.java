package Algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by yuhuazh on 5/17/2016.
 */
public class SeriDeseBT {
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            List<String> values = new ArrayList<>();
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            //traversal by level
            while(!q.isEmpty()){
                TreeNode cur = q.poll();
                if(cur!=null) {
                    values.add(Integer.toString(cur.val));
                    q.offer(cur.left);
                    q.offer(cur.right);
                }
                else{
                    values.add(null);
                }
            }
            //remove tail nulls
            String last = values.get(values.size()-1);
            while(last==null){
                values.remove(values.size()-1);
                last=values.get(values.size()-1);
            }
            StringBuilder sb = new StringBuilder();
            for(String s : values){
                sb.append(s);
                sb.append(',');
            }
            sb.deleteCharAt(sb.length()-1);
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] values = data.split(",");
            if(values.length==0) return null;
            int count=1;
            int visited=0;
            int idx=0;

            while(idx<values.length){
                if(values[idx]!=null){
                    int curValue = Integer.valueOf(values[idx]);
                    TreeNode curNode = new TreeNode(curValue);

            }


        }
    }
}
