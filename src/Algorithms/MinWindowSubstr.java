package Algorithms;

import java.util.ArrayList;
import java.util.HashMap;

public class MinWindowSubstr {

	public static void main(String[] args){
		String s="ADOBECODEBANC";
		String t="ABC";
		System.out.println(minWindow(s,t));
	}
	
	public static String minWindow(String S, String T) {
        if(S==null || T==null || S.equals("") || T.equals("")){
        	return "";
        }
        
        if(S.equals(T)){
        	return S;
        }
        
        HashMap<Integer,Integer> expected = new HashMap<Integer,Integer>();
        HashMap<Integer,Integer> found = new HashMap<Integer,Integer>();
        
        for(int i=0;i<T.length();i++){
        	int ch = (int)T.charAt(i);
        	if(expected.containsKey(ch)){
        		expected.put(ch, expected.get(ch)+1);
        	}
        	else{
        		expected.put(ch, 1);
        		found.put(ch,0);
        	}
        }
        
        ArrayList<Integer> indices = new ArrayList<Integer>();
        int left=0;
        int right=0;
        int counter=0;
        String window="";
        
        for(int j=0; j<S.length(); j++){
        	int ch2 = (int)S.charAt(j);
        	right=j;
        	
        	if(!expected.containsKey(ch2)){
        		continue;
        	}
       
        	indices.add(right);
        	//always put when matches; will be used for moving the left
        	found.put(ch2, found.get(ch2)+1);
        	if(found.get(ch2)<=expected.get(ch2)){
        		counter++;
        	}
        	
        	if(counter>=T.length()){
        		int ll =(int) S.charAt(indices.get(left));
        		//moving left if there are extra char in window
        		while(found.get(ll)>expected.get(ll)){
        			left++;
        			found.put(ll, found.get(ll)-1);
        			ll = (int) S.charAt(indices.get(left));
        		}
        		
        		if( window.equals("") || right-indices.get(left)<window.length() ){
        			window = S.substring(indices.get(left), right+1); 
        		}
        	}
        }
        return window;
        
    }
	
	
}
