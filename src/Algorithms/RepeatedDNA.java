package Algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class RepeatedDNA {

	//the poin here is to change string to bit and reduce memory
	public List<String> findRepeatedDnaSequences(String s) {
		List<String> res = new ArrayList<String>();
		if(s==null || s.length()<1){
			return res;
		}
		
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		map.put('A', 0);
		map.put('C', 1);
		map.put('G', 2);
		map.put('T', 3);
		HashMap<Integer,Integer> visited = new HashMap<Integer,Integer>();
		int sum=0;
		for(int i=0; i<s.length(); i++){
			sum = ( (sum<<2)+map.get(s.charAt(i)))& 0xFFFFF; //remove first Character of 2 bits; mask on lower 20 bits.
			if(i<9){
				continue;
			}
			if(!visited.containsKey(sum)){
				visited.put(sum,1);
			}
			else{
				int c=visited.get(sum); //the count check is in hashmap; not in res. because map is O(1) but res.contains() causes time-out
				if(c==1){
					String sub = s.substring(i-9, i+1);
					res.add(sub);
				}
				visited.put(sum, c+1);
			}
		}
		return res;
	}
}
