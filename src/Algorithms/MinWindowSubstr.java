

import java.util.HashMap;
import java.util.HashSet;

public class MinWindowSubstr {

	public String minWindow(String S, String T) {
		if(S==null||S.length()<1||T==null||T.length()<1){
			return "";
		}
		if(S.length()<T.length()){
			return "";
		}
		
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		char[] chs = T.toCharArray();
		for(char c : chs){
			if(map.containsKey(c)){
				map.put(c, map.get(c)+1);
			}
			else{
				map.put(c, 1);
			}
		}
		
		int min=Integer.MAX_VALUE;
		int l=0;
		int r=0;
		int count=T.length();
		
		int walker=0;
		int runner=0;
		int curCount=0;
		
		while(runner<S.length()){
			char c = S.charAt(runner);
			if(map.containsKey(c)){
				if(map.get(c)>0){ //a valid count
					curCount++;
				}
				map.put(c, map.get(c)-1); //also record the redundant 
								
				if(curCount==count){
					char d = S.charAt(walker);
					while(!map.containsKey(d)|| map.get(d)<0){
						if(map.containsKey(d)){
							map.put(d, map.get(d)+1);
						}
						walker++;
						d=S.charAt(walker);
					}
					if((runner-walker+1)<min){
						min=runner-walker+1;
						r=runner+1;
						l=walker;
					}
					map.put(d, map.get(d)+1);
					curCount--;
					walker++;
				}
			}
			runner++;
		}
		return S.substring(l,r);
	}
}
