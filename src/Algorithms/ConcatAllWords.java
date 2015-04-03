package Algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ConcatAllWords {

	public List<Integer> findSubstring(String S, String[] L) {
		List<Integer> res = new ArrayList<Integer>();
		
		//boundary check
		if(S==null||S.length()<1 || L==null || L.length<1 || L[0]==null || L[0].length()<1){
			return res;
		}
		int count=L.length;
		int step=L[0].length();
		if(S.length()<count*step){
			return res;
		}
		//set up variables
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		for(String w : L){
			if(map.containsKey(w)){
				map.put(w, map.get(w)+1);
			}
			else{
				map.put(w, 1);
			}
		}
		int walker = 0;
		int runner = 0;
		
		//scan
		for(int i=0;i<step;i++){
			HashMap<String,Integer> visited = new HashMap<String,Integer>();
			int curCount=0;
			runner=i;
			while(runner<=S.length()-step){
				String cur = S.substring(runner,runner+step);
				if(map.containsKey(cur)){ //a valid word
					curCount++;
					if(visited.isEmpty()){
						walker = runner;
					}
					if(visited.containsKey(cur)){
						visited.put(cur, visited.get(cur)+1);
					}
					else{
						visited.put(cur, 1);
					}
					if(visited.get(cur)>map.get(cur)){
						//dup, move walker
						String temp = S.substring(walker, walker+step);
						while(!temp.equals(cur)){
							curCount--;
							if(visited.containsKey(temp)){
								if(visited.get(temp)==1){
									visited.remove(temp);
								}
								else{
									visited.put(temp, visited.get(temp)-1);
								}
							}
							walker+=step;
						}
						curCount--;
						walker +=step;
					}
					
					if(curCount==count){
						res.add(walker);
						//move walker one step
						String temp = S.substring(walker, walker+step);
						if(visited.containsKey(temp)){
							if(visited.get(temp)==1){
								visited.remove(temp);
							}
							else{
								visited.put(temp, visited.get(temp)-1);
							}
						}
						curCount--;
						walker +=step;
					}
				}
				else{ //invalid word, move walker
					curCount=0;
					visited.clear();
				}
				runner+=step;
			}//end of while
		}//end of for
		return res;
	}
}
