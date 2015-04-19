package Algorithms;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

	public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<String>();
		if(n<=0){
			return res;
		}
		
		helper(n,n,"",res); //n left and n right left (in hands, ready to assign)
		return res;
	}
	
	//put down one left, needs to pair up one right;
	//or put down a few left, add right afterwards;
	//left is always equal or bigger than right in item; the residual left should be always no bigger than right
	private void helper(int l, int r, String item, List<String> res){
		if(r<l){
			return;
		}
		if(r==0 && l==0){
			res.add(item);
			return;
		}
		if(l>0){
			helper(l-1,r,item+"(",res);
		}
		if(r>0){
			helper(l,r-1,item+")",res);
		}
	}
}
