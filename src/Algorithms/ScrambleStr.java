package Algorithms;

import java.util.Arrays;

public class ScrambleStr {

	public static void main(String[] args){
		String s1= "abcdefghijklmnopq";
		String s2= "efghijklmnopqcadb";
		ScrambleStr inst = new ScrambleStr();
		System.out.println(inst.isScramble(s1, s2));
	}
	
	public boolean isScramble(String s1, String s2) {
		if((s1==null&&s2==null) || (s1.length()==0&&s2.length()==0)) return true;
		if((s1==null||s2==null) || (s1.length()==0||s2.length()==0)) return false;
		if(s1.length()!=s2.length()) return false;
		if(s1.length()==1){
			return s1.charAt(0)==s2.charAt(0);
		}
		if(s1.equals(s2)) return true;
		
		char[] c1=s1.toCharArray();
		char[] c2=s2.toCharArray();
		Arrays.sort(c1);
		Arrays.sort(c2);
		for(int i=0;i<c1.length;i++){
			if(c1[i]!=c2[i]) return false;
		}
		
		
		int len = s1.length();
		for(int l=1;l<len;l++){
			if( (isScramble(s1.substring(0, l),s2.substring(0, l))&& isScramble(s1.substring(l,len),s2.substring(l,len)))
				||
				(isScramble(s1.substring(0,l),s2.substring(len-l, len)) && isScramble(s1.substring(l,len),s2.substring(0,len-l)))
			  ) return true;
		}
		return false;
	}
}
