package Algorithms;

import java.util.ArrayList;

public class RecoverBST {

	public void recoverTree(TreeNode root) {
		if(root==null){
			return;
		}
		ArrayList<TreeNode> pre = new ArrayList<TreeNode>();
		pre.add(null);
		ArrayList<TreeNode> rev = new ArrayList<TreeNode>();
		traverseTree(root, pre, rev);
		if(rev.size()>0){
			int temp = rev.get(0).val;
			rev.get(0).val = rev.get(1).val;
			rev.get(1).val = temp;
		}
		return;
    }
	
	private void traverseTree(TreeNode root, ArrayList<TreeNode> pre, ArrayList<TreeNode> rev){
		if(root==null){
			return;
		}
		traverseTree(root.left, pre, rev);
		if(pre.get(0)!=null && root.val<pre.get(0).val){
			if(rev.size()==0){
				rev.add(pre.get(0));
				rev.add(root);
			}
			else{
				rev.add(1,root);
			}
		}
		pre.set(0, root);
		traverseTree(root.right, pre, rev);
		return;
	}
}
