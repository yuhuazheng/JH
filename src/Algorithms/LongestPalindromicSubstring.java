package Algorithms;

public class LongestPalindromicSubstring {

	public String longestPalindrome(String s) {
		if(s==null || s.length()<1){
			return s;
		}
		String max="";
		for(int i=0; i<2*s.length()-1;i++){
			int left=i/2;
			int right=i/2;
			if(i%2==1){
				//center is between two chars
				right++;
			}
			String cur = lengthOfPanlindrome(s,left,right);
			if(cur.length()>max.length()){
				max=cur;
			}
		}
		return max;
	}
	
	private String lengthOfPanlindrome(String s, int left, int right){
		while(left>=0&&right<s.length()&&(s.charAt(left)==s.charAt(right))){
			left--;
			right++;
		}
		return s.substring(left+1, right);
	}
				
}
