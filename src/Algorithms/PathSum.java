package Algorithms;

public class PathSum {

	public static void main(String[] args){
		TreeNode root=new TreeNode(0);
		int sum=1;
		PathSum helper = new PathSum();
		System.out.println(helper.hasPathSum(root, sum));
	}
	
	public boolean hasPathSum(TreeNode root, int sum) {
		if(root==null){
			return false;
		}
		
		//leaf node
		if(root.left==null&&root.right==null){
			return root.val==sum?true:false;
		}
		
		return (hasPathSum(root.left,sum-root.val) || hasPathSum(root.right,sum-root.val));
	}
	       
}
