package Algorithms;

import java.util.Arrays;

public class LongestCommonPrefix {
	
	public static void main(String[] args){
		LongestCommonPrefix helper = new LongestCommonPrefix();
		String[] strs = {"aa","ab"};
		System.out.println(helper.longestCommonPrefix(strs));
	}
	
	public String longestCommonPrefix2(String[] strs) {
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

	public String longestCommonPrefix(String[] strs) {
		if(strs==null||strs.length==0) return "";
		String common = strs[0];
		for(int i=0;i<strs.length;i++){
			if(strs[i].length()<common.length()){
				common=strs[i];
			}
		}
		if(common.length()==0) return "";

		while(common.length()>0){
			boolean isvalid=true;
			for(int j=0;j<strs.length;j++){
				String match = strs[j].substring(0,common.length());
				if(!common.equals(match)){
					isvalid=false;
					break;
				}
			}
			if(isvalid){
				return common;
			}
			else{
				common=common.substring(0,common.length()-1);
			}
		}
		return "";
	}
}
