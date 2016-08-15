
import java.util.ArrayList;
import java.util.List;

public class RestoreIP {

	public static void main(String[] args){
		String s="1111";
		RestoreIP inst = new RestoreIP();
		for(String cur :inst.restoreIpAddresses(s)){
			System.out.println(cur);
		}
	}
	
	public List<String> restoreIpAddresses(String s) {
		List<String> res = new ArrayList<>();
		if(s==null||s.length()<4) return res;
		DFS(s,0,new ArrayList<String>(),res);
		return res;
	}

	private void DFS(String s, int start, List<String> item, List<String> res){
		if(start<s.length()&&item.size()>=4) return;
		if(start>=s.length()&&item.size()!=4) return;
		if(start>=s.length()&&item.size()==4){
			res.add(item.get(0)+'.'+item.get(1)+'.'+item.get(2)+'.'+item.get(3));
			return;
		}

		if(s.charAt(start)=='0'){
			item.add("0");
			DFS(s,start+1,item,res);
			item.remove(item.size()-1);
			return;
		}

		for(int i=1;i<=3;i++){
			if(start+i>s.length())
				break;
			String part = s.substring(start, start+i);
			int v = Integer.valueOf(part);
			if(v<0||v>255)
				break;
			item.add(part);
			DFS(s,start+i,item,res);
			item.remove(item.size()-1);
		}
	}
}
