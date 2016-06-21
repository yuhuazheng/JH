
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WordBreakII {

	public List<String> wordBreak(String s, Set<String> dict) {
		ArrayList<String> res = new ArrayList<String>();
		if(s==null||s.length()<1||dict==null||dict.size()<1){
			return res;
		}
		int n = s.length();
		ArrayList<String>[] buf = new ArrayList[n+1]; //buf[i] is all words in dict ended with s.charAt(i)
		ArrayList<String> empty = new ArrayList<>();
		buf[0]=empty;
		generateBuf(buf,s,dict);
		if(buf[n]==null) return res;
		List<String> item = new ArrayList<>();
		helper(s,buf,n,item,res);
		return res;
	}

	private void generateBuf(ArrayList<String>[] dp,String s,Set<String> dict){
		for(int i=0; i<s.length(); i++){
			//i是开始位置
			if( dp[i] == null ) continue; //前面的部分必须是可以匹配的
			for(String word:dict){
				int len = word.length();
				int end = i+len;
				if(end > s.length()) continue;
				if(s.substring(i,end).equals(word)){
					if(dp[end] == null){
						dp[end] = new ArrayList<String>();
					}
					dp[end].add(word);//记录上一个位置
				}
			}
		}
	}

	private void helper(String s, ArrayList<String>[] buf, int end, List<String> item, ArrayList<String> res){
		if(end<=0&&item.size()>0){
			StringBuilder sb = new StringBuilder();
			for(String w: item){
				sb.append(w);
				sb.append(' ');
			}
			sb.deleteCharAt(sb.length()-1);
			res.add(sb.toString());
			return;
		}

		for(String w: buf[end]){
			int l = w.length();
			item.add(0,w);
			helper(s,buf,end-l,item,res);
			item.remove(0);
		}
		return;
	}
}
