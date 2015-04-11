package Algorithms;

import java.util.Arrays;

public class LongestCommonPrefix {
	
	public static void main(String[] args){
		LongestCommonPrefix helper = new LongestCommonPrefix();
		String[] strs = {"flower","flow","flight"};
		System.out.println(helper.longestCommonPrefix(strs));
	}
	
	public String longestCommonPrefix(String[] strs) {
		if(strs==null||strs.length<1){
			return "";
		}
		
		String common = strs[0];
		for(int i=0;i<strs.length;i++){
			if(strs[i].length()<common.length()){
				common=strs[i];
			}
		}
		
		boolean valid=true;
		while(!common.isEmpty()){
			for(int i=0;i<strs.length;i++){
				if(!strs[i].substring(0, common.length()).equals(common)){
					valid=false;
					break;
				}
			}
			if(!valid){
				common = common.substring(0, common.length()-1);
				valid=true;
			}
			else{
				break;
			}
		}
		return common;
	}
}
