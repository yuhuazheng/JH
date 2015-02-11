package myPractice;

public class TreeSumNumbers {

	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		TreeNode e1 = new TreeNode(0);
		root.left = e1;
		TreeSumNumbers helper = new TreeSumNumbers();
		System.out.println(helper.sumNumbers(root));
	}
	
	public int sumNumbers(TreeNode root) {
		if(root==null){
			return 0;
		}
		return sumSubTrees(root,0);
	}
	
	public int sumSubTrees(TreeNode root,int preNumber){
		if(root==null){
			return 0;
		}
		
		if(root.left==null&&root.right==null){
			return (preNumber*10+root.val);
		}
		
		return (sumSubTrees(root.left,preNumber*10+root.val)+sumSubTrees(root.right,preNumber*10+root.val));
	}
}

