package myPractice;

import java.util.LinkedList;
import java.util.Queue;

public class BTMaxDepth2 {

	public static void main(String[] args){
		TreeNode root = new TreeNode(0);
		BTMaxDepth2 helper = new BTMaxDepth2();
		System.out.println(helper.maxDepth(root));
	}
	
	//no recur way
	//BFS to get deepest level
	public int maxDepth(TreeNode root) {
		if(root==null){
			return 0;
		}
		
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		int depth=0;
		int curNum=1;
		int nextNum=0;
		
		while(!q.isEmpty()){
			TreeNode cur = q.poll();
			curNum--;
			if(cur.left!=null){
				nextNum++;
				q.add(cur.left);
			}
			if(cur.right!=null){
				nextNum++;
				q.add(cur.right);
			}
			if(curNum<=0){
				curNum=nextNum;
				nextNum=0;
				depth++;
			}
		}
		
		return depth;
	}
}
