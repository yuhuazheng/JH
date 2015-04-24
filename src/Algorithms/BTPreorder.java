package Algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BTPreorder {

	public static void main(String[] args){
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		t1.left=t2;
		t1.right=t3;
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		t2.left=t4;
		t3.right=t5;
		BTPreorder inst = new BTPreorder();
		List<Integer> res = inst.preorderTraversal(t1);
		for(Integer i : res){
			System.out.println(i);
		}
	}
	
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if(root==null){
			return res;
		}
		Stack<TreeNode> buf = new Stack<TreeNode>();
		buf.push(root);
		while(!buf.isEmpty()){
			TreeNode cur = buf.pop();
			if(cur!=null){
				res.add(cur.val);
				while(cur.left!=null){
					buf.push(cur.right);
					res.add(cur.left.val);
					cur=cur.left;
				}
				buf.push(cur.right);
			}
		}
		return res;	
	}
}
