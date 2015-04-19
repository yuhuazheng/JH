package Algorithms;

import java.util.LinkedList;
import java.util.Queue;

public class NextRightPointer {

	public class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;
		TreeLinkNode(int x) { val = x; }
		}
	
	public void connect(TreeLinkNode root) {
		if(root==null || (root.left==null && root.right==null) ){
			return;
		}
		
		Queue<TreeLinkNode> buf = new LinkedList<TreeLinkNode>();
		int curLevel=0;
		int nextLevel=0;
		root.next=null;
		if(root.left!=null){
			buf.offer(root.left);
			curLevel++;
		}
		if(root.right!=null){
			buf.offer(root.right);
			curLevel++;
		}
		TreeLinkNode cur = null;
		TreeLinkNode next = null;
		while(!buf.isEmpty()){
			cur = buf.poll();
			if(cur.left!=null){
				buf.offer(cur.left);
				nextLevel++;
			}
			if(cur.right!=null){
				buf.offer(cur.right);
				nextLevel++;
			}
			curLevel--;
			if(curLevel>0){
				next=buf.peek();
				cur.next=next;
			}
			else{
				cur.next=null;
				curLevel=nextLevel;
				nextLevel=0;
			}
		}
		return;
	}
}
