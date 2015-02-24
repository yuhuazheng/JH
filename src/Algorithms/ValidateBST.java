package Algorithms;

import java.util.ArrayList;

public class ValidateBST {

	public static void main(String[] args){
		TreeNode root = new TreeNode(0);
		ValidateBST helper = new ValidateBST();
		System.out.println(helper.isValidBST(root));
	}
	
	public boolean isValidBST(TreeNode root) {
		if(root==null){
			return true;
		}
		if(root.left==null && root.right==null){
			return true;
		}
		ArrayList<Integer> pre = new ArrayList<Integer>();
		pre.add(null);
		return isValid(root,pre);
	}
	
	public boolean isValid(TreeNode node, ArrayList<Integer> pre){
		if(node==null){
			return true;
		}
		boolean validLeft = isValid(node.left,pre);
		if(pre.get(0)!=null && node.val<=pre.get(0)){
			return false;
		}
		pre.set(0, node.val);
		return validLeft && isValid(node.right,pre);
	}
	
}
