package Algorithms;

import java.util.HashMap;

public class FractionToRecurringDecimal {

	public static void main(String[] args){
		FractionToRecurringDecimal helper = new FractionToRecurringDecimal();
		System.out.println(helper.fractionToDecimal(1, 6));
	}
	
	public String fractionToDecimal(int numerator, int denominator) {
		if(numerator==0){
			return "0";
		}
		StringBuilder res = new StringBuilder();
		if(numerator<0 ^ denominator<0){
			res.append("-");
		}
		
		long n=numerator,d=denominator; //integer min –2,147,483,648 will overflow with abs(), bigger than 2,147,483,647.
		n=Math.abs(n);					//use long to hold the value
		d=Math.abs(d);
		res.append(n/d); // integer part
		long r=(n%d); //r needs to be long. because it need to bigger than d to start dividing. 
		if(r==0){
			return res.toString();
		}
		res.append(".");
		HashMap<Long,Integer>  map = new HashMap<Long,Integer>();
		while(r!=0){
			if(map.containsKey(r)){
				res.insert(map.get(r), "(");
				res.append(")");
				break;
			}
			map.put(r, res.length());
			r*=10;
			res.append(Long.toString(r/d));
			r= (r%d);
		}
		return res.toString();
	}
	
}
