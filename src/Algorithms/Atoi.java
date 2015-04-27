package Algorithms;

public class Atoi {

	public int myAtoi(String str) {
		if(str==null || str.length()<1){
			return 0;
		}
		int i=0;
		while(i<str.length() && str.charAt(i)==' '){
			i++;
		}
		int sign=1;
		if(i<str.length() && str.charAt(i)=='+'){
			i++;
		}
		else if(i<str.length() && str.charAt(i)=='-'){
			sign=-1;
			i++;
		}
		int limit = Integer.MAX_VALUE/10;
		int num=0;
		while(i<str.length() && (str.charAt(i)>='0' && str.charAt(i)<='9')){
			int digit = str.charAt(i)-'0';
			if(num>limit || (num==limit && digit>=8)){
				return sign>0?Integer.MAX_VALUE:Integer.MIN_VALUE;
			}
			num=num*10+digit;
			i++;
		}
		return sign*num;
	}
}
