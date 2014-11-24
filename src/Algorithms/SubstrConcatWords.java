package Algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class SubstrConcatWords {

	public static void main(String[] args){
		String S="abaababbaba";
		String[] L={"ab","ba","ab","ba"};
		System.out.println(findSubstring(S,L).toString());
	}
	
	public static List<Integer> findSubstring(String S, String[] L) {
        List<Integer> indices = new ArrayList<Integer>();
		
		if(S==null || L==null || S.equals("") || L.length<1){
        	return indices;
        }
		
		if(L.length==1){
			for(int i=0; i<S.length();i++){
				String str = S.substring(i,i+L[0].length()>=S.length()?S.length():(i+L[0].length()));
				if(str.equals(L[0])){
					indices.add(i);
				}
			}
			return indices;
		}
		
		HashMap<String,Integer> words = new HashMap<String,Integer>();
		HashMap<String,Integer> found = new HashMap<String,Integer>();
		int unit = L[0].length();
		int counter = 0;
		int idx=-1;
		int step=1;
		
		for(String str:L){
			if(words.containsKey(str)){
				words.put(str, words.get(str)+1);
			}
			else{
				words.put(str, 1);
				found.put(str, 0);
			}
		}
		
		for(int i=0; i<S.length(); i=i+step){
			String cur = S.substring(i, i+unit>=S.length()?S.length():(i+unit));
			
			if(words.containsKey(cur)){
				step=unit;
				if(idx<0){
					idx=i;
					found.put(cur, found.get(cur)+1);
					counter++;
				}
				else{
					if(found.get(cur)<words.get(cur)){
						found.put(cur, found.get(cur)+1);
						counter++;
					}
					else{
						//move beginer
						for(int j=idx; j<i; j=j+unit){
							String str1 = S.substring(j, j+unit);
							if(!str1.equals(cur)){
								found.put(cur, found.get(cur)-1);
								counter--;
							}
							else{
								idx=j+unit;
								break;
							}
						}
					}
				}
			}
			else{
				if(idx>=0){
					//reset
					//restart from the end of last match
					i=idx;
					idx=-1;
					counter=0;
					step=1;
					
					for(String key: found.keySet()){
						found.put(key, 0);
					}
				}
			}
			
			if(idx>=0 && counter==L.length){
				//a valid container
				indices.add(idx);
				String first = S.substring(idx, idx+unit);
				idx=idx+unit;
				found.put(first, found.get(first)-1);
				counter--;
			}
		}
		return indices;
    }
}
