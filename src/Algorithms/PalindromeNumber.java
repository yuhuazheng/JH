package Algorithms;

public class PalindromeNumber {

	public  boolean isPalindrome(int x) {
		if(x<0){
			return false;
		}
		int div=1;
		while(x>=div*10){
			div*=10;
		}
		while(x>=0){
			int low = x%10;
			int high = x/div;
			if(high!=low){
				return false;
			}
			x=(x%div)/10;
			div/=100;
		}
		return true;
	}
}
