
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
	
	public static List<Integer> findSubstring(String s, String[] words) {
		List<Integer> res = new ArrayList<>();
		if(s==null||s.length()==0||words==null||words.length==0||words[0].length()==0) return res;
		int step = words[0].length();
		int sublen= step*words.length;
		if(s.length()<sublen) return res;

		HashMap<String,Integer> buf = new HashMap<>();
		for(String w:words){
			if(!buf.containsKey(w))
				buf.put(w,1);
			else
				buf.put(w,buf.get(w)+1);
		}
		int count = words.length;

		int walker = 0;
		int runner = 0;
		//scan
		for(int i=0;i<step;i++){
			HashMap<String,Integer> visited = new HashMap<>();
			int curCount=0;
			runner=i;
			while(runner<=s.length()-step){
				String cur = s.substring(runner,runner+step);
				if(buf.containsKey(cur)){ //a valid word
					if(curCount==0)
						walker=runner;
					curCount++;
					if(!visited.containsKey(cur))
						visited.put(cur,1);
					else
						visited.put(cur,visited.get(cur)+1);

					while(buf.get(cur)<visited.get(cur)){//dup, move walker
						String temp = s.substring(walker, walker+step);
						visited.put(temp,visited.get(temp)-1);
						curCount--;
						walker+=step;
					}

					if(curCount==count){
						res.add(walker);
						//move walker one step
						String temp = s.substring(walker, walker+step);
						visited.put(temp,visited.get(temp)-1);
						curCount--;
						walker+=step;
					}
				}
				else{ //invalid word, clear
					curCount=0;
					visited.clear();
				}
				runner+=step;
			}//end of while
		}//end of for
		return res;
    }
}
