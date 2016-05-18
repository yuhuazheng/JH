package Algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by yuhuazh on 5/17/2016.
 */
public class SeriDeseBT {

    public static void main(String[] args) {
        String data = "1,2,null,3,null,4,null,5";
        Codec inst = new Codec();
        String s = inst.serialize(inst.deserialize(data));
        System.out.println(s);
    }

    public static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if(root==null) return "";
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
                    values.add("null");
                }
            }
            //remove tail nulls
            String last = values.get(values.size()-1);
            while(last.equals("null")){
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
            if(data==null||data.length()==0) return null;

            String[] values = data.split(",");
            //build nodes
            List<TreeNode> nodes = new ArrayList<>();
            for(String v : values){
                if(v.equals("null")){
                    nodes.add(null);
                }
                else{
                    TreeNode cur = new TreeNode(Integer.valueOf(v));
                    nodes.add(cur);
                }
            }

            Queue<TreeNode> preLevel = new LinkedList<>();
            preLevel.offer(nodes.get(0));
            Queue<TreeNode> curLevel = new LinkedList<>();
            int idx=1;
            while(!preLevel.isEmpty()){
                TreeNode cur = preLevel.poll();
                if(cur!=null){
                    if(idx>=nodes.size()){
                        break;
                    }
                    TreeNode nt = nodes.get(idx);
                    curLevel.offer(nt);
                    cur.left=nt;
                    idx++;
                    if(idx>=nodes.size()){
                        break;
                    }
                    nt=nodes.get(idx);
                    curLevel.offer(nt);
                    cur.right=nt;
                    idx++;
                }

                if(preLevel.isEmpty()) {
                    preLevel = curLevel;
                    curLevel = new LinkedList<>();
                }
            }
            return nodes.get(0);
        }
    }
}
