package Algorithms;

import java.util.Stack;

public class SimplifyPath {

	public static void main(String[] args){
		String raw = "/a/./b/../../c/";
		SimplifyPath inst = new SimplifyPath();
		System.out.println(inst.simplifyPath(raw));
	}
	
	public String simplifyPath(String path) {
		if(path==null || path.length()<1){
			return "/";
		}
		
		String[] parts = path.split("[/]");
		Stack<String> buf = new Stack<String>();
		String cur = null;
		for(int i=0;i<parts.length;i++){
			cur=parts[i];
			if(cur!=null && cur.length()>0){
				if(cur.equals(".")){
					continue;
				}
				else if(cur.equals("..")){
					if(!buf.isEmpty()){
						buf.pop();
					}
					else{
						continue;
					}
				}
				else{
					buf.push(cur);
				}
			}
		}
		StringBuilder res = new StringBuilder();
		if(buf.isEmpty()){
			return "/";
		}
		while(!buf.isEmpty()){
			res.insert(0, buf.pop());
			res.insert(0, "/");
		}
		return res.toString();
	}
}
