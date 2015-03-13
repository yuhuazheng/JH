package Algorithms;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {

	public static void main(String[] args){
		String s="leetcode";
		Set<String> dict = new HashSet<String>();
		dict.add("leet");
		dict.add("code");
		WordBreak inst = new WordBreak();
		System.out.println(inst.wordBreak(s, dict));
	}
	
	public boolean wordBreak(String s, Set<String> dict) {
		if(s==null || s==""){
			return true;
		}
		if(dict==null || dict.size()<1){
			return false;
		}
		boolean[] res = new boolean[s.length()+1]; //true if substring up to i is breakable
		res[0]=true;
		for(int i=0;i<s.length();i++){
			for(int j=0;j<=i;j++){
				String str1 = s.substring(j, i+1);
				if(res[j]&&dict.contains(str1.toString())){
					res[i+1]=true;
					break;
				}
			}
			
		}
		return res[s.length()];
	}
}
