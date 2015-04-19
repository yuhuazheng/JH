package Algorithms;

import java.util.ArrayList;

public class FlattenBT {

	public static void main(String[] args){
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		n1.left=n2;
		n1.right=n3;
		FlattenBT inst = new FlattenBT();
		inst.flatten(n1);
	}
	
	public void flatten(TreeNode root) {
		ArrayList<TreeNode> pre = new ArrayList<TreeNode>();
		pre.add(null);
	    helper(root, pre);
	}
	private void helper(TreeNode root, ArrayList<TreeNode> pre)
	{
	    if(root == null)
	        return;
	    TreeNode right = root.right;
	    if(pre.get(0)!=null)
	    {
	        pre.get(0).left = null;
	        pre.get(0).right = root;
	    }
	    pre.set(0,root);
	    helper(root.left, pre);
	    helper(right, pre);
	}
}
