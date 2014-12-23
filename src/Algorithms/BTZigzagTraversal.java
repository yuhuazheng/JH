package myPractice;

import java.util.ArrayList;
import java.util.List;

public class BTZigzagTraversal {

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    
		List<List<Integer>> values = new ArrayList<List<Integer>>();
		if(root==null){
			return values;
		}
		
		List<TreeNode> curLevel = new ArrayList<TreeNode>();
		int order =-1; //1:left to right; -1: right to left
		
		curLevel.add(root);
		while(!curLevel.isEmpty()){
			List<Integer> curValues = new ArrayList<Integer>();
			List<TreeNode> nextLevel = new ArrayList<TreeNode>();
			for(TreeNode cur : curLevel){
				curValues.add(cur.val);
				if(order>0){
					if(cur.right!=null){
						nextLevel.add(0,cur.right);
					}
					if(cur.left!=null){
						nextLevel.add(0,cur.left);
					}
				}
				else{
					if(cur.left!=null){
						nextLevel.add(0,cur.left);
					}
					if(cur.right!=null){
						nextLevel.add(0,cur.right);
					}
				}
			}
			curLevel=nextLevel;
			values.add(curValues);
			order = order*-1;
		}
		return values;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
