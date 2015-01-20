package myPractice;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder1 {

	public static void main(String[] args){
		String start = "hit";
		String end = "cog";
		Set<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		
		WordLadder1 helper = new WordLadder1();
		System.out.println(helper.ladderLength(start,end,dict));
		
	}
	
	public int ladderLength(String start, String end, Set<String> dict){
        if(start == null || start.length()<1 || end ==null || end.length()<1 || dict ==null || dict.size()<1){
        	return 0;
        }
        if(start.length()!= end.length()){
        	return 0;
        }
        if(start.equals(end)){
        	return 0;
        }
        
        //to build transition steps from one word to another, there are two ways:
        //1 is to build a map from dict, which however can be too expensive if dict is large (it likely is.)
        //2 is to go over 26 letters from a to z.
        
        //BFS
        HashSet<String> visited = new HashSet<String>();
        LinkedList<String> next = new LinkedList<String>();
        int levels =1;
        int upCounter=0;
        int downCounter=1;
        
        visited.add(start);
        next.add(start);
                
        while(!next.isEmpty()){
        	
        	//go through the queue
        	String curStr = next.poll();
        	downCounter--;
        	
        	//find 1-step words of curStr
        	for(int i=0; i<curStr.length();i++){
        		//array is direct read/write
        		char[] charArr = curStr.toCharArray();
        		for(char c='a'; c<='z'; c++){
        			charArr[i]=c;
        			String candidate = new String(charArr);
        			if(end.equals(candidate)){
        				return (levels+1);
        			}
        			if(!visited.contains(candidate)&& dict.contains(candidate)){
        				visited.add(candidate);
        				next.add(candidate);
        				upCounter++;
        			}
        		}
        	}
        	
        	//update levels
        	if(downCounter==0){
        		//one level is finished
        		levels++;
        		downCounter=upCounter;
        		upCounter=0;
        	}
        }
        
        return 0;
    }
}
