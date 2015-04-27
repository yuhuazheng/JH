package Algorithms;

public class ValidNumber {

	public boolean isNumber(String s) {
		if(s==null || s.length()<1){
			return false;
		}
		//deal with head whitespace
		int i=0;
		while(i<s.length()&&s.charAt(i)==' '){
			i++;
		}
		if(i<s.length()&&(s.charAt(i)=='+'||s.charAt(i)=='-')){
			i++;
		}
		boolean isNum=false;
		//123.456, 123 or 456 needs to present plus a single point
		while(i<s.length()&&(s.charAt(i)>='0'&&s.charAt(i)<='9')){
			i++;
			isNum=true;
		}
		if(i<s.length() && s.charAt(i)=='.'){
			i++;
		}
		while(i<s.length()&&(s.charAt(i)>='0'&&s.charAt(i)<='9')){
			i++;
			isNum=true;
		}
		//123.456e+789. before e and after e must be number: e9 and 0e are wrong
		if(isNum && i<s.length()&&(s.charAt(i)=='e'||s.charAt(i)=='E')){
			i++;
			isNum=false;
			if(i<s.length()&& (s.charAt(i)=='+'||s.charAt(i)=='-')){
				i++;
			}
		}
		while(i<s.length()&&(s.charAt(i)>='0'&&s.charAt(i)<='9')){
			i++;
			isNum=true;
		}
		//deal with tail whitespace
		while(i<s.length()&&s.charAt(i)==' '){
			i++;
		}
		return isNum&&i==s.length();
	}
}
