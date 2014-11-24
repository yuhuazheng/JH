package Algorithms;

public class PlusOne {

	public static void main(String[] args){
		int[] num1={1,2,3};
		System.out.println(plusOne(num1));
	}
	
	public static int[] plusOne(int[] digits) {
		if(digits==null || digits.length<1){
			return digits;
		}
		else{
			int carry=1;
			for(int i=digits.length-1;i>=0;i--){
				int result = (digits[i]+carry)%10;
				carry=(digits[i]+carry)/10;
				digits[i]=result;
				if(carry==0){
					return digits;
				}
			}
			int[] newdigits = new int[digits.length+1];
			newdigits[0]=carry;
			return newdigits;	
		}
	}
}
