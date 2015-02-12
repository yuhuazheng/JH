package myPractice;

public class BTMaxDepth {

	public static void main(String[] args){
		TreeNode root = new TreeNode(0);
		BTMaxDepth helper = new BTMaxDepth();
		System.out.println(helper.maxDepth(root));
	}
	
	public int maxDepth(TreeNode root) {
		if(root==null){
			return 0;
		}
		
		if(root.left==null && root.right==null){
			return 1;
		}
		
		return 1+Math.max(maxDepth(root.left), maxDepth(root.right));
	}
}
