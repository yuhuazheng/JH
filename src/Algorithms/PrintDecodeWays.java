package Algorithms;

import java.util.ArrayList;
import java.util.List;

public class PrintDecodeWays {

	public static void main(String[] args){
		String s = "12";
		List<List<String>> res = new ArrayList<List<String>>();
		helper(s,0,new ArrayList<String>(), res);
		for(List<String> cur : res){
			System.out.println(cur);
		}
	}
	
	private static void helper(String s, int idx, ArrayList<String> item, List<List<String>> res){
		if(idx==s.length()&& !item.isEmpty()){
			res.add(new ArrayList<String>(item));
			return;
		}
		
		char c=s.charAt(idx);
		if(c>='1'&&c<='9'){
			item.add(""+c);
			helper(s,idx+1,item,res);
			item.remove(item.size()-1);
		}
		if(idx+1<s.length()){
			char n = s.charAt(idx+1);
			if( (c=='1'&&n>='0'&&n<='9')
			   ||(c=='2'&&n>='1'&&n<='6')){
				item.add(""+c+n);
				helper(s,idx+2,item,res);
				item.remove(item.size()-1);
			}
		}
		return;
	}
}
