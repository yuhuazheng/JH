package myPractice;

public class BTMinDepth {

	public static void main(String[] main){
		TreeNode root = new TreeNode(0);
		BTMinDepth helper = new BTMinDepth();
		System.out.println(helper.minDepth(root));
	}
	
	public int minDepth(TreeNode root){
		if(root==null){
			return 0;
		}
		
		//leaf
		if(root.left==null && root.right==null){
			return 1;
		}
		else{
			int left=Integer.MAX_VALUE;
			int right=left;
			
			if(root.left!=null){
				left=minDepth(root.left);
			}
			if(root.right!=null){
				right=minDepth(root.right);
			}
			return 1+Math.min(left, right);
		}
		
	}
}
