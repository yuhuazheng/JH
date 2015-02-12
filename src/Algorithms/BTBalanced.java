package myPractice;

public class BTBalanced {

	public static void main(String[] args){
		TreeNode root = new TreeNode(0);
		BTBalanced helper = new BTBalanced();
		System.out.println(helper.isBalanced(root));
	}
	
	public boolean isBalanced(TreeNode root){
		if(root==null){
			return true;
		}
		
		if(depthBalance(root)==-1){
			return false;
		}
		else{
			return true;
		}
	}
	
	public int depthBalance(TreeNode root){
		if(root==null){
			return 0;
		}
		
		if(root.left==null&&root.right==null){
			return 1;
		}
		
		int left=depthBalance(root.left);
		int right=depthBalance(root.right);
		if(left==-1||right==-1){
			return -1;
		}
		if(Math.abs(left-right)>1){
			return -1;
		}
		return 1+Math.max(left, right);
	}
}
