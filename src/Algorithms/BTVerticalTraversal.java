package Algorithms;

import java.util.*;

/**
 * Created by yuhuazh on 3/19/2016.
 */
public class BTVerticalTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;

        Map<Integer, List<Integer>> map = new TreeMap<>(); // order by key; easier than list as index will change
        bfs(root, map); // pick 0 as the middle pivot; cols would be -2,-1,0,1,2,...
        return new ArrayList<>(map.values()); // already sorted; return type is Collection; must cast
    }

    private void bfs(TreeNode root, Map<Integer, List<Integer>> map) {
        if (root == null) {
            return; // do nothing
        }
        Queue<NodeIndex> queue = new ArrayDeque<>();
        queue.offer(new NodeIndex(root, 0));

        while (!queue.isEmpty()) {
            NodeIndex indexedNode = queue.poll();
            TreeNode node = indexedNode.nd;
            if (node == null) {
                continue; // do nothing
            }
            int index = indexedNode.idx;
            List<Integer> list = map.containsKey(index) ? map.get(index) : new ArrayList<Integer>();
            list.add(node.val);
            map.put(index, list);
            queue.offer(new NodeIndex(node.left, index - 1));
            queue.offer(new NodeIndex(node.right, index + 1));
        }
    }

    class NodeIndex{
        TreeNode nd;
        int idx;

        public NodeIndex(TreeNode t, int i){
            nd=t;
            idx=i;
        }
    }
}
