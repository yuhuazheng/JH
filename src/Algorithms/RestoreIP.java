package Algorithms;

import java.util.ArrayList;
import java.util.List;

public class RestoreIP {

	public static void main(String[] args){
		String s="010010";
		RestoreIP inst = new RestoreIP();
		for(String cur :inst.restoreIpAddresses(s)){
			System.out.println(cur);
		}
	}
	
	public List<String> restoreIpAddresses(String s) {
		ArrayList<String> res = new ArrayList<String>();
		if(s==null || s.length()<4){
			return res;
		}
		helper(s,0,new StringBuilder(), res);
		return res;
	}
	
	//backtracking
	private void helper(String s, int start, StringBuilder prefix, ArrayList<String> res){
		if(start>=s.length()&& prefix.length()>0 && prefix.toString().split("[.]").length==4){
			//valid ip address must have 4 parts
			res.add(prefix.toString());
			return;
		}
		
		//start from 255, decrease to 0, good for long strings
		for(int i=3;i>=1;i--){
			if(start+i>s.length()){
				continue;
			}
			String subs = s.substring(start, start+i);
			if(subs.charAt(0)=='0'&& subs.length()>1){ //01,001 are not valid ip address
				continue;
			}
			int address = Integer.parseInt(subs);
			if(address>=0 && address<=255){
				int c=prefix.length();
				if(prefix.length()>0){
					prefix.append(".");
				}
				prefix.append(subs);
				String[] ss =prefix.toString().split("[.]");
				if(ss.length<=4){
					helper(s,start+i,prefix,res);
				}
				prefix.delete(c, prefix.length()); //trace back is important!
			}
		}
		return;
	}
}
