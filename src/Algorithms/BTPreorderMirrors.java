package Algorithms;

import java.util.ArrayList;

public class BTPreorderMirrors {

	public ArrayList<Integer> preorderTraversal(TreeNode root) {
	    ArrayList<Integer> res = new ArrayList<Integer>();
	    TreeNode cur = root;
	    TreeNode pre = null;
	    while(cur != null)
	    {
	        if(cur.left == null)
	        {
	            res.add(cur.val);
	            cur = cur.right;
	        }
	        else
	        {
	            pre = cur.left;
	            while(pre.right!=null && pre.right!=cur)
	                pre = pre.right;
	            if(pre.right==null)
	            {	//build connection back to itself
	                res.add(cur.val);
	                pre.right = cur;
	                cur = cur.left;
	            }
	            else
	            {	//detect the connection to itself, remove it and go to right
	                pre.right = null;
	                cur = cur.right;
	            }
	        }
	    }
	    return res;
	}
}
