
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class SubstrConcatWords {

	public static void main(String[] args){
		String S="aaaaaaaa";
		String[] L={"aa","aa","aa"};
		System.out.println(findSubstring(S,L).toString());
	}
	
	public static List<Integer> findSubstring(String S, String[] L) {
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
		HashMap<String,Integer> mapbk = (HashMap)map.clone();
		int walker = 0;
		int runner = 0;

		//scan
		for(int i=0;i<step;i++){
			map = (HashMap)mapbk.clone();
			int curCount=0;
			runner=i;
			while(runner<=S.length()-step){
				String cur = S.substring(runner,runner+step);
				if(map.containsKey(cur)){ //a valid word
					if(curCount==0)
						walker=runner;
					curCount++;
					map.put(cur,map.get(cur)-1);
					while(map.get(cur)<0){//dup, move walker
						String temp = S.substring(walker, walker+step);
						map.put(temp,map.get(temp)+1);
						curCount--;
						walker+=step;
					}

					if(curCount==count){
						res.add(walker);
						//move walker one step
						String temp = S.substring(walker, walker+step);
						map.put(temp,map.get(temp)+1);
						curCount--;
						walker+=step;
					}
				}
				else{ //invalid word, clear
					curCount=0;
					map = (HashMap)mapbk.clone();
				}
				runner+=step;
			}//end of while
		}//end of for
		return res;
    }
}
