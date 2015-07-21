package Algorithms;

public class PronounceInteger {

	public static void main(String[] args){
		int num = 1718234218;
		System.out.println(SayInteger(num));
	}
	
	public static String SayInteger(int num){
		//billion, million, thousand,hundred
		StringBuilder res = new StringBuilder();
		int temp = num/1000000000;
		num = num%1000000000;
		if(temp>0){
			res.append(SayHundred(temp));
			res.append(" Billion ");
		}
		temp=num/1000000;
		num = num%1000000;
		if(temp>0){
			res.append(SayHundred(temp));
			res.append(" Million ");
		}
		temp=num/1000;
		num = num%1000;
		if(temp>0){
			res.append(SayHundred(temp));
			res.append(" Thousand ");
		}
		if(num>0){
			res.append(SayHundred(num));
		}
		return res.toString();
	}
	
	public static String SayHundred(int num){
		StringBuilder res = new StringBuilder();
		int temp = num/100;
		num=num%100;
		if(temp>0){
			res.append(SayOneDigit(temp));
			res.append(" hundred ");
		}
		if(num>0){
			if(temp>0)
				res.append("and ");
			if(num>19){
				temp=num/10;
				num=num%10;
				String[] tenth = {"twenty","thirty","fourty","fifty","sixty","seventy","eighty","ninety"};
				int offset = temp-2;
				res.append(tenth[offset]);
				if(num>0){
					res.append(" ");
					res.append(SayOneDigit(num));
				}
			}
			else if(num>9){
				String[] teens = {"ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
				int offset = num-10;
				res.append(teens[offset]);
			}
			else{
				res.append(SayOneDigit(num));
			}
		}
		return res.toString();
	}
	
	public static String SayOneDigit(int num){
		String[] digits = {"one","two","three","four","five","six","seven","eight","nine"};
		return digits[num-1];
	}
}
