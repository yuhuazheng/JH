package Algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class BSTPostOrderTraversal {

	public static void main(String[] args){
		
		//construct a tree
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		root.left = left;
		root.right = right;
		TreeNode ll = new TreeNode(4);
		left.left = ll;
		TreeNode rr = new TreeNode(7);
		right.right = rr;
		
		//postorder traversal
		ArrayList<Integer> values = (ArrayList)postorderTraversal(root);
		System.out.println(values.toString());
	}

	public static List<Integer> postorderTraversal(TreeNode root) {
        
		Stack<TreeNode> unvisited = new Stack<TreeNode>();
        List<Integer> values = new ArrayList<Integer>();
        HashSet<TreeNode> visited = new HashSet<TreeNode>();
        
        if(root==null){
        	return values;
        }
        else if(root.left==null && root.right==null){
        	values.add(root.val);
        	return values;
        }
        else{
        	unvisited.push(root);
        	while(!unvisited.empty()){
        		TreeNode current = unvisited.pop();
        		if( (current.left==null && current.right==null)
        			||(current.left==null && visited.contains(current.right))
        			||(current.right==null && visited.contains(current.left))
        			||(current.left!=null && current.right!=null && visited.contains(current.left) && visited.contains(current.right))
        		  )	{
        			//leave node
        			values.add(current.val);
        			visited.add(current);
        		}
        		
        		else if(current.left!=null && !visited.contains(current.left)){
        			unvisited.push(current);
        			unvisited.push(current.left);
        		}
        		else if(current.right!=null && !visited.contains(current.right)){
        			unvisited.push(current);
        			unvisited.push(current.right);
        		}
        	}
        	return values;
        }
        
    }
}

	//Definition for binary tree
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}