package Algorithms;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {

	public static void main(String[] args){
		TreeNode root=new TreeNode(0);
		int sum=1;
		PathSum2 helper = new PathSum2();
		List<List<Integer>> results = helper.pathSum(root, sum);
		for(List<Integer> alist : results){
			System.out.println(alist.toArray());
		}
	}
	
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		
		if(root==null){
			return results;
		}
		
		//leaf node
		if(root.left==null&&root.right==null){
			if(root.val==sum){
				List<Integer> cur = new ArrayList<Integer>();
				cur.add(root.val);
				results.add(cur);
				return results;
			}
			else{
				return results;
			}
		}
		
		List<List<Integer>> left = pathSum(root.left,sum-root.val);
		if(left!=null){
			for(List<Integer> alist : left){
				alist.add(0, root.val);
				results.add(alist);
			}
		}
		
		List<List<Integer>> right = pathSum(root.right,sum-root.val);
		if(right!=null){
			for(List<Integer> alist : right){
				alist.add(0, root.val);
				results.add(alist);
			}
		}
		
		return results;
	}      
}
