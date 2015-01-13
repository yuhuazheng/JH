package myPractice;

import java.util.HashMap;

public class ConstructBTPrePost {

	public static void main(String[] args){
		int[] preorder = new int[3];
		int[] inorder = new int[3];
		ConstructBTPrePost helper = new ConstructBTPrePost();
		TreeNode root = helper.buildTree(preorder, inorder);
	}
	
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null || preorder.length<1 || inorder==null || inorder.length<1 || preorder.length!=inorder.length){
        	return null;
        }
        
        if(preorder.length==1){
        	TreeNode root = new TreeNode(preorder[0]);
        	return root;
        }
        
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0; i<inorder.length; i++){
        	map.put(inorder[i], i);
        }
        
        return getRoot(preorder, inorder, 0 ,preorder.length-1, 0, inorder.length-1, map);
    }
	
	public TreeNode getRoot(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd, HashMap<Integer,Integer> map){
		
		int nodeNum = preEnd-preStart+1;
		//base case
		if(nodeNum==1){
			return (new TreeNode(preorder[preStart]));
		}
		//find left and right sub-tree
		TreeNode root = new TreeNode(preorder[preStart]);
		int rootIdx = map.get(preorder[preStart]);
		
		int nodesL = rootIdx-inStart;
		if(nodesL>0){
			root.left=getRoot(preorder, inorder, preStart+1 ,preStart+nodesL, inStart, rootIdx-1, map);
		}
		
		int nodesR = inEnd-rootIdx;
		if(nodesR>0){
			root.right=getRoot(preorder, inorder, preEnd-nodesR+1 ,preEnd, rootIdx+1, inEnd, map);
		}
		
		return root;
	}
}
