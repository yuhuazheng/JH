
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
		List<String> item = new ArrayList<>();
		helper(s,buf,n,item,res);
		return res;
	}

	private void generateBuf(ArrayList<String>[] buf,String s,Set<String> dict){
		int n = s.length();
		for(int j=1;j<=n;j++){
			for(String w : dict){
				int l = w.length();
				int i = j-l;
				if(i<0) continue;
				if(s.substring(i,j).equals(w)){
					if(buf[j]==null){
						ArrayList<String> temp = new ArrayList<>();
						buf[j]=temp;
					}
					buf[j].add(w);
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

		if(buf[end]==null)
			return;

		for(String w: buf[end]){
			int l = w.length();
			item.add(0,w);
			helper(s,buf,end-l,item,res);
			item.remove(0);
		}
		return;
	}
}
