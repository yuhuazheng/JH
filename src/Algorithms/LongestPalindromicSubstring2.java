package Algorithms;

public class LongestPalindromicSubstring2 {

	public String longestPalindrome(String s) {
		if(s==null || s.length()<=1){
			return s;
		}
		//DP, good design
		boolean[][] palin = new boolean[s.length()][s.length()];
		String max="";
		for(int i=s.length()-1; i>=0;i--){
			for(int j=i; j<s.length();j++){
				if( (s.charAt(i)==s.charAt(j)) && (palin[i+1][j-1] || j-1<=i+1) ){ //j-1<=i+1 covers cases like "aba" or "aa"
					palin[i][j]=true;
					if(j-i+1>max.length()){
						max=s.substring(i, j+1);
					}
				}
			}
		}
		return max;
	}
}
