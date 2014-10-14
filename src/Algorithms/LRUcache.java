package Algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class LRUcache {
    
	Map<Integer,Integer> cacheMap;
	List<Integer> visitList;
	int capacity;
	
    public LRUcache(int capacity) {
    
		cacheMap = new HashMap<Integer,Integer>();
    	visitList = new ArrayList<Integer>();
    	this.capacity=capacity;
    }
    
    public int get(int key) {
        if(cacheMap!=null && !cacheMap.isEmpty() && cacheMap.containsKey(key)){
        	//update visitList
        	MoveKeytoEnd(visitList,key);
        	
        	return cacheMap.get(key);
        }
        return -1;
    }
    
    public void set(int key, int value) {
    	if(cacheMap ==null && cacheMap.isEmpty()){
    		cacheMap = new HashMap<Integer,Integer>();
    		cacheMap.put(key, value);
    		visitList.add(key);
    	}
    	else{
    		if(cacheMap.containsKey(key)){
    			cacheMap.put(key, value);
    			//update visitList
    			MoveKeytoEnd(visitList,key);
    		}
    		else if(cacheMap.size()<= capacity){
    			cacheMap.put(key, value);
    			visitList.add(key);
    		}
    		else{
    			//remove lru key
    			int keyToRemove = visitList.get(0);
    			cacheMap.remove(keyToRemove);
    			cacheMap.put(key, value);
    			
    			//updatevistList
    			visitList.remove(0);
    			visitList.add(key);
    		}
        }
    }

public void MoveKeytoEnd(List<Integer> visitList2, int key){
	if(visitList2==null || visitList2.isEmpty()){
		return;
	}
	
	int keyIdx = visitList2.lastIndexOf(key);
	if(keyIdx<0){
		//no such key
		return;
	}
	else{
		//move it to the end of the list
		visitList2.remove(keyIdx);
		visitList2.add(key);
		return;
	}
}

}
