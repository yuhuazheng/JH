package Algorithms;

import java.util.Arrays;

public class SortedArrayBST {

	public static void main(String[] args){
		int[] num=new int[2];
		SortedArrayBST helper = new SortedArrayBST();
		TreeNode result = helper.sortedArrayToBST(num);
	}
	
	public TreeNode sortedArrayToBST(int[] num) {
		if(num==null||num.length<1){
			return null;
		}
		if(num.length==1){
			return (new TreeNode(num[0]));
		}
		return BSTFromRange(num,0,num.length-1);
	}
	
	public TreeNode BSTFromRange(int[] num, int l, int r){
		if(l>r){
			return null;
		}
		int m= (l+r)/2;
		TreeNode res = new TreeNode(num[m]);
		res.left = BSTFromRange(num,l,m-1);
		res.right = BSTFromRange(num,m+1,r);
		return res;
	}
}
