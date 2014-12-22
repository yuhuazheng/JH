package Algorithms;

import java.util.ArrayList;
import java.util.List;

public class BTLevelOrderTraversal {

	public List<List<Integer>> levelOrder(TreeNode root) {
    
		List<List<Integer>> values = new ArrayList<List<Integer>>();
		if(root==null){
			return values;
		}
		
		List<TreeNode> curLevel = new ArrayList<TreeNode>();
		
		
		curLevel.add(root);
		while(!curLevel.isEmpty()){
			List<Integer> curValues = new ArrayList<Integer>();
			List<TreeNode> nextLevel = new ArrayList<TreeNode>();
			for(TreeNode cur : curLevel){
				curValues.add(cur.val);
				if(cur.left!=null){
					nextLevel.add(cur.left);
				}
				if(cur.right!=null){
					nextLevel.add(cur.right);
				}
			}
			curLevel=nextLevel;
			values.add(curValues);
		}
		return values;
    }
}

