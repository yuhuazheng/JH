package Algorithms;

import java.util.HashMap;

public class IsomorphicStrings {

	 public boolean isIsomorphic(String s, String t) {
		   if((s==null && t==null) || (s.length()<1&& t.length()<1)) return true;
		   HashMap<Character, Character> map1 = new HashMap<Character,Character>();
		   HashMap<Character, Character> map2 = new HashMap<Character,Character>();
		   for(int i=0;i<s.length();i++){
			   char c1=s.charAt(i);
			   char c2=t.charAt(i);
			   if(map1.containsKey(c1)){
				   if(c2!=map1.get(c1)) return false;
			   }
			   if(map2.containsKey(c2)){
				   if(c1!=map2.get(c2)) return false;
			   }
			   map1.put(c1, c2);
			   map2.put(c2, c1);
		   }
		   return true;
	 }
}
