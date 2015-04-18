package Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangles {

	public static void main(String[] args){
		List<Integer> l1 = new ArrayList<Integer>();
		l1.add(-1);
		List<Integer> l2 = new ArrayList<Integer>();
		l2.add(2); l2.add(3);
		List<Integer> l3 = new ArrayList<Integer>();
		l3.add(1); l3.add(-1); l3.add(-3);
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		triangle.add(l1);triangle.add(l2);triangle.add(l3);
		Triangles helper = new Triangles();
		System.out.println(helper.minimumTotal(triangle));
	}
	
	
	public int minimumTotal(List<List<Integer>> triangle) {
		if(triangle==null || triangle.size()<1){
			return 0;
		}
		
		List<Integer> pre = new ArrayList<Integer>();
		pre.add(triangle.get(0).get(0));
		List<Integer> cur = new ArrayList<Integer>();
		List<Integer> val = new ArrayList<Integer>();
		int min=pre.get(0);
		int v=0;
		for(int i=1; i<triangle.size();i++){
			val = triangle.get(i);
			min = Integer.MAX_VALUE;
			for(int j=0;j<=i;j++){
				if(j==0){
					v=pre.get(j)+val.get(j);
				}
				else if(j==i){
					v=pre.get(j-1)+val.get(j);
				}
				else{
					v=Math.min(pre.get(j)+val.get(j), pre.get(j-1)+val.get(j));
				}
				cur.add(j,v);
				if(v<min){
					min=v;
				}
			}
			pre=cur;
			cur = new ArrayList<Integer>();
		}
		return min;
	}
}
