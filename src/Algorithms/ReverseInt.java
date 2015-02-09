package Algorithms;

public class ReverseInt {

	public static void main(String[] args){
		ReverseInt helper = new ReverseInt();
		System.out.println(helper.reverse(1463847412));
	}
	
	public int reverse(int x) {
		int value=Math.abs(x);
		int res=0;
		while(value>0){
			int digit = value%10;
			if(res>(Integer.MAX_VALUE-digit)/10){
				return 0;
			}
			else{
				res=res*10+digit;
			}
			value=value/10;
		}
		return x>0?res:-res;
	}
}

