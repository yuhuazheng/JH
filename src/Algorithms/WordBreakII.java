package Algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WordBreakII {

	public List<String> wordBreak(String s, Set<String> dict) {
		ArrayList<String> res = new ArrayList<String>();
		if(s==null||s.length()<1||dict==null||dict.size()<1){
			return res;
		}
		helper(s,dict,0,"",res);
		return res;
	}
	
	private void helper(String s, Set<String> dict, int start, String item, ArrayList<String> res){
		if(start>=s.length()){
			res.add(item);
			return;
		}
		
		StringBuilder str = new StringBuilder();
		for(int i=start; i<s.length();i++){
			str.append(s.charAt(i));
			if(dict.contains(str.toString())){
				String newItem = item.length()>0? item+" "+str.toString() : str.toString();
				helper(s,dict,i+1,newItem,res);
			}
		}
		return;
	}
}
