package myPractice;

public class SameTree {

	public static void main(String[] args){
		TreeNode p = new TreeNode(0);
		TreeNode q = new TreeNode(0);
		SameTree helper = new SameTree();
		System.out.println(helper.isSameTree(p,q));
	}
	
	public boolean isSameTree(TreeNode p, TreeNode q){
		if(p==null&&q==null){
			return true;
		}
		if(p==null || q==null){
			return false;
		}
		if(q.val!=p.val){
			return false;
		}
		return (isSameTree(p.left,q.left) && isSameTree(p.right,q.right));
	}
}
