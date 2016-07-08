
import java.util.Stack;

public class BSTIterator {

	private Stack<TreeNode> stack  = new Stack<TreeNode>();
	
    public BSTIterator(TreeNode root) {
        while(root!=null){
        	stack.push(root);
        	root=root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode res= stack.pop();
        TreeNode cur = res;
        if(cur.right!=null){
        	cur=cur.right;
        	while(cur!=null){
        		stack.push(cur);
        		cur=cur.left;
        	}
        }
        return res.val;
    }
}


/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */