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
		
		TreeLinkNode cur = root;
		TreeLinkNode nextLevelHead = root.left;
		while(cur!=null && nextLevelHead!=null){
			cur.left.next = cur.right;
			TreeLinkNode nt = cur.next;
			if(nt!=null){ //moving to right
				cur.right.next=nt.left;
				cur=nt;
			}
			else{ //moving down to next level
				cur = nextLevelHead;
				nextLevelHead = nextLevelHead.left;
			}
		}
	}
}
