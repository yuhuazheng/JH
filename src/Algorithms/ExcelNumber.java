package Algorithms;

public class ExcelNumber {

	public int titleToNumber(String s) {
		if(s==null||s.length()<1){
			return -1;
		}
		char[] chs=s.toCharArray();
		int res=0;
		for(int i=0;i<chs.length;i++){
			int digit = chs[i]-'A'+1;
			res = res*26+digit;
		}
		return res;
	}
}
