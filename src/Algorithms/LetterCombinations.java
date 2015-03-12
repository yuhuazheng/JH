package Algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinations {

	public List<String> letterCombinations(String digits) {
		//build hashmap between digit and letters
		HashMap<Character,String> maps = new HashMap<Character,String>();
		maps.put('1', null);
		maps.put('2', "abc");
		maps.put('3', "def");
		maps.put('4', "ghi");
		maps.put('5', "jkl");
		maps.put('6', "mno");
		maps.put('7', "pqrs");
		maps.put('8', "tuv");
		maps.put('9', "wxyz");
		maps.put('0', " ");
		
		List<String> res = new ArrayList<String>();
		
		if(digits==null || digits.length()<1){
			return res;
		}
		
		res=combineFromK(digits,0, maps);
		return res;
	}
	
	private List<String> combineFromK(String digits,int k, HashMap<Character,String> maps){
		List<String> res = new ArrayList<String>();
		if(k<0){
			res.add(null);
			return res;
		}
		String letters = maps.get(digits.charAt(k));
		if(k==digits.length()-1){
			//last letter, boundary condition.
			for(char c : letters.toCharArray()){
				res.add(Character.toString(c));
			}
			return res;
		}
		else{
			for(char c : letters.toCharArray()){
				for(String s: combineFromK(digits,k+1,maps)){
					res.add(Character.toString(c)+s);
				}
			}
			return res;
		}
	}
}
