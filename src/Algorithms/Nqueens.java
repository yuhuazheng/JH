package Algorithms;

import java.util.ArrayList;
import java.util.List;

public class Nqueens {

	public static void main(String[] args){
		Nqueens inst = new Nqueens();
		List<String[]> res = inst.solveNQueens(9);
		System.out.println(res.size());
	}
	
	public List<String[]> solveNQueens(int n) {
		List<String[]> res = new ArrayList<String[]>();
		if(n<=0) return res;
		if(n==1){
			String[] temp = {"Q"};
			res.add(temp);
			return res;
		}
		
		boolean[] col = new boolean[n];
		List<point[]> res1 = new ArrayList<point[]>();
		point[] item = new point[n];
		helper(0,col,item,res1);
		for(point[] t : res1){
			String[] strarray = new String[n];
			StringBuilder sb = new StringBuilder();
			for(int j=0; j<n;j++){
				
				point p = t[j];
				for(int i=0;i<n;i++){
					if(i==p.c){
						sb.append("Q");
					}
					else{
						sb.append(".");
					}
				}
				strarray[j]=sb.toString();
				sb = new StringBuilder();
			}
			res.add(strarray);
		}
		return res;
	}
	
	//find kth queen for kth row
	private void helper(int k, boolean[] col, point[] item, List<point[]> res1){
		int n = col.length;
		if(k==n&&item.length>0) res1.add(item.clone());
		for(int i=0; i<n;i++){
			point p = new point(k,i);
			if(col[i]==false&&isValidAngel(k,p,item)){
				col[i]=true;
				item[k]=p;
				helper(k+1,col,item,res1);
				item[k]=new point(0,0);
				col[i]=false;
			}
		}
	}
	
	private boolean isValidAngel(int k, point p, point[] item){
		if(k>=item.length) return false;
		for(int i=0;i<k;i++){
			point p1 = item[i];
			if( (p.r-p1.r)==(p.c-p1.c) || (p.r-p1.r)==(p1.c-p.c)) return false;
		}
		return true;
	}
	
	private class point{
		int r;
		int c;
		public point(int a, int b){
			r=a;
			c=b;
		}
	}
}
