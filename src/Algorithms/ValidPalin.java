package Algorithms;

public class ValidPalin {

	public static void main(String[] args){
		ValidPalin helper = new ValidPalin();
		helper.isPalindrome("ab2a");
	}
	
	public boolean isPalindrome(String s) {
		if(s==null || s.length()<1){
			return true;
		}
		
		String s1=s.toLowerCase();
		StringBuilder sb = new StringBuilder();
		for(char c :s1.toCharArray()){
			if((c>='a'&&c<='z') || (c>='0'&&c<='9') ){
				sb.append(c);
			}
		}
		s1=sb.toString();
		if(s1==null || s1.length()<1){
			return true;
		}
		
		int l=0;
		int r=s1.length()-1;
		char c1=s1.charAt(l);
		char c2=s1.charAt(r);
		while(l<r){
			c1=s1.charAt(l);
			c2=s1.charAt(r);
			if(c1!=c2){
				return false;
			}
			l++;
			r--;
		}
		return true;
	}
}
