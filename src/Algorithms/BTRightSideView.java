package Algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BTRightSideView {

	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if(root==null){
			return res;
		}
		Queue<TreeNode> buf = new LinkedList<TreeNode>();
		buf.offer(root);
		int curCount=1;
		int nextCount=0;
		while(!buf.isEmpty()){
			curCount--;
			TreeNode temp=buf.poll();
			if(temp.left!=null){
				buf.offer(temp.left);
				nextCount++;
			}
			if(temp.right!=null){
				buf.offer(temp.right);
				nextCount++;
			}
			if(curCount==0){
				res.add(temp.val);
				curCount=nextCount;
				nextCount=0;
			}
		}
		return res;
	}
}
