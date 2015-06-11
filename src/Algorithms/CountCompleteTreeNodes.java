package Algorithms;

public class CountCompleteTreeNodes {

	public static void main(String[] args){
		TreeNode n1= new TreeNode(1);
		TreeNode n2= new TreeNode(2);
		n1.left=n2;
		CountCompleteTreeNodes inst = new CountCompleteTreeNodes();
		System.out.println(inst.countNodes(n1));
	}
	
	public int countNodes(TreeNode root) {
        if(root==null) return 0;
        int leftH=0;
        int rightH=0;
        TreeNode l=root;
        TreeNode r=root;
        while(l!=null){
        	leftH++;
        	l=l.left;
        }
        while(r!=null){
        	rightH++;
        	r=r.right;
        }
        if(leftH==rightH) return (int) (Math.pow(2,leftH)-1);
        return countNodes(root.left)+countNodes(root.right)+1;
	}
}
