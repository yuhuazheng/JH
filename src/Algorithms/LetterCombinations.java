
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinations {

	public List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<>();
		if(digits==null||digits.length()==0) return res;

		HashMap<Character,String> mp = new HashMap<>();
		mp.put('0'," ");
		mp.put('2',"abc");
		mp.put('3',"def");
		mp.put('4',"ghi");
		mp.put('5',"jkl");
		mp.put('6',"mno");
		mp.put('7',"pqrs");
		mp.put('8',"tuv");
		mp.put('9',"wxyz");

		res=mapDigit(digits,0,mp,res);
		return res;
	}

	private List<String> mapDigit(String digits,int idx,HashMap<Character,String> mp,List<String> res){
		if(idx==digits.length()) return res;
		List<String> res2= new ArrayList<>();
		char c = digits.charAt(idx);
		if(!mp.containsKey(c)) return res;
		String chs = mp.get(c);
		for(char ch:chs.toCharArray()){
			if(res.size()==0){
				StringBuilder sb = new StringBuilder();
				sb.append(ch);
				res2.add(sb.toString());
			}
			else{
				for(String s:res){
					StringBuilder sb = new StringBuilder(s);
					sb.append(ch);
					res2.add(sb.toString());
				}
			}
		}
		return mapDigit(digits,idx+1,mp,res2);
	}

	public static void main(String[] args) {
		LetterCombinations inst = new LetterCombinations();
		System.out.println(inst.letterCombinations("2").size());
	}
}
