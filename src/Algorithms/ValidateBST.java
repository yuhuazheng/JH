
import java.util.ArrayList;
import java.util.Stack;

public class ValidateBST {

	public static void main(String[] args){
		TreeNode root = new TreeNode(3);
		TreeNode r2 = new TreeNode(1);
		TreeNode r3 = new TreeNode(5);
		TreeNode r4 = new TreeNode(0);
		TreeNode r5 = new TreeNode(2);
		TreeNode r6 = new TreeNode(4);
		TreeNode r7 = new TreeNode(6);
		root.left=r2;
		root.right=r3;
		r2.left=r4;
		r2.right=r5;
		r3.left=r6;
		r3.right=r7;

		ValidateBST helper = new ValidateBST();
		System.out.println(helper.isValidBST(root));
	}
	
	public boolean isValidBST(TreeNode root) {
		if (root == null) {
			return true;
		}
		if (root.left == null && root.right == null) {
			return true;
		}
		/*ArrayList<Integer> pre = new ArrayList<Integer>();
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
	}*/

		TreeNode pre = null;
		Stack<TreeNode> stk = new Stack<>();

		TreeNode cur = root;
		while(cur!=null) {
			stk.push(cur);
			cur = cur.left;
		}

		while (!stk.isEmpty()) {
			cur = stk.pop();
			if (pre!=null && cur.val <= pre.val)
				return false;
			pre = cur;
			if (cur.right != null){
				cur=cur.right;
				while(cur!=null) {
					stk.push(cur);
					cur = cur.left;
				}
			}
		}
		return true;
	}
}
