

	package myPractice;

	public class SymmetricTree {

		public static void main(String[] args){
			TreeNode root = new TreeNode(0);
			SymmetricTree helper = new SymmetricTree();
			System.out.println(helper.isSymmetric(root));
		}
		
		public boolean isSymmetric(TreeNode root){
			if(root==null){
				return true;
			}
			return areSymmetric(root.left,root.right);
		}
		
		public boolean areSymmetric(TreeNode p,TreeNode q){
			if(p==null&&q==null){
				return true;
			}
			if(p==null||q==null){
				return false;
			}
			if(p.val!=q.val){
				return false;
			}
			return (areSymmetric(p.left,q.right) && areSymmetric(p.right,q.left));
		}
	}
