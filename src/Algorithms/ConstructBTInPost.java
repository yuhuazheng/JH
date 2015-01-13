package myPractice;

import java.util.HashMap;

public class ConstructBTInPost {

	public static void main(String[] args){
		int[] postorder = new int[3];
		int[] inorder = new int[3];
		ConstructBTInPost helper = new ConstructBTInPost();
		TreeNode root = helper.buildTree(inorder,postorder);
	}
	
	public TreeNode buildTree(int[] inorder,int[] postorder) {
        if(postorder==null || postorder.length<1 || inorder==null || inorder.length<1 || postorder.length!=inorder.length){
        	return null;
        }
        
        if(postorder.length==1){
        	TreeNode root = new TreeNode(postorder[0]);
        	return root;
        }
        
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0; i<inorder.length; i++){
        	map.put(inorder[i], i);
        }
        
        return getRoot(postorder, inorder, 0 ,postorder.length-1, 0, inorder.length-1, map);
    }
	
	public TreeNode getRoot(int[] postorder, int[] inorder, int postStart, int postEnd, int inStart, int inEnd, HashMap<Integer,Integer> map){
		
		int nodeNum = postEnd-postStart+1;
		//base case
		if(nodeNum==1){
			return (new TreeNode(postorder[postEnd]));
		}
		//find left and right sub-tree
		TreeNode root = new TreeNode(postorder[postEnd]);
		int rootIdx = map.get(postorder[postEnd]);
		
		int nodesL = rootIdx-inStart;
		if(nodesL>0){
			root.left=getRoot(postorder, inorder, postStart ,postStart+nodesL-1, inStart, rootIdx-1, map);
		}
		
		int nodesR = inEnd-rootIdx;
		if(nodesR>0){
			root.right=getRoot(postorder, inorder, postEnd-nodesR ,postEnd-1, rootIdx+1, inEnd, map);
		}
		
		return root;
	}
}
