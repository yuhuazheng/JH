package Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Anagrams {

	public static void main(String[] args){
		String[] strs= { "",""};
		Anagrams helper = new Anagrams();
		List<String> results = helper.anagrams(strs);
		for(String cur : results){
			System.out.print(cur+",");
		}
	}
	
    public List<String> anagrams(String[] strs) {
        List<String> results = new ArrayList<String>();
    	
    	if(strs==null || strs.length<2){
    		return results;
        }
    	
    	HashMap<String, ArrayList<String>> map = new HashMap<String,ArrayList<String>>();
    	
    	for(String str1: strs){
    		char[] charray = str1.toCharArray();
    		Arrays.sort(charray);
    		String str2 = new String(charray);
    		if(map.containsKey(str2)){
    			ArrayList<String> value = map.get(str2);
    			value.add(str1); 
    			map.put(str2, value);
    		}
    		else{
    			ArrayList<String> value = new ArrayList<String>();
    			value.add(str1);
    			map.put(str2, value);
    		}
    	}
    	
    	for(String str3 : map.keySet()){
    		ArrayList<String> value = map.get(str3);
    		if(value.size()>1){
    			results.addAll(value);
    		}
    	}
    	return results;
    }
}
