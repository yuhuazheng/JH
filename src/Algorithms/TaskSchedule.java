package Algorithms;

import java.util.HashMap;

public class TaskSchedule {

	public static void main(String[] args){
		String tasks = "AABABCD";
		System.out.println(schedule(tasks,2));
	}
	
	public static int schedule(String str,int cd){
    	int ts = 0;
    	HashMap<Character,Integer> dict = new HashMap<Character,Integer>();
    	int i=0;
    	while(i < str.length()){
            	char c = str.charAt(i);
            	if(!dict.containsKey(c) || dict.get(c)<ts){
            		dict.put(c,ts+cd);
            		i++;
            	}
            	ts++;
    	}
    	return ts-1;
	}

}
