package Algorithms;

import java.util.ArrayList;
import java.util.HashMap;

public class PrintBTVertical {

	public static void main(String[] args){
		TreeNode t1= new TreeNode(1);
		TreeNode t2= new TreeNode(2);
		TreeNode t3= new TreeNode(3);
		TreeNode t4= new TreeNode(4);
		TreeNode t5= new TreeNode(5);
		TreeNode t6= new TreeNode(6);
		TreeNode t7= new TreeNode(7);
		TreeNode t8= new TreeNode(8);
		TreeNode t9= new TreeNode(9);
		t1.left=t2;
		t1.right=t3;
		t2.left=t4;
		t2.right=t5;
		t3.left=t6;
		t3.right=t7;
		t6.right=t8;
		t7.right=t9;
		
		HashMap<Integer,ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>();
		int[] mostL = new int[1];
		preorderTraversalVertical(t1,0,map,mostL);
		int i=mostL[0];
		while(!map.isEmpty()){
			if(map.containsKey(i)){
				System.out.println(map.get(i));
				map.remove(i);
			}
			i++;
		}
	}
	
	public static void preorderTraversalVertical(TreeNode r,int offset,HashMap<Integer,ArrayList<Integer>> map, int[] mostL){
		if(r==null) return;
		if(map.containsKey(offset)){
			map.get(offset).add(r.val);
		}
		else{
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.add(r.val);
			map.put(offset, temp);
		}
		if(offset<mostL[0]) mostL[0]=offset;
		preorderTraversalVertical(r.left,offset-1,map,mostL);
		preorderTraversalVertical(r.right,offset+1,map,mostL);
	}
}
