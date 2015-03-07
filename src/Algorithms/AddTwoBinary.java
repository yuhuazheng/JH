package Algorithms;

public class AddTwoBinary {

	public String addBinary(String a, String b) {
		if(a==null || a.length()==0){
			return b;
		}
		if(b==null || b.length()==0){
			return a;
		}
		
		int i=a.length()-1;
		int j=b.length()-1;
		int carry=0;
		StringBuilder res = new StringBuilder();
		while(i>=0&&j>=0){
			int digit = (int)((a.charAt(i)-'0')+(b.charAt(j)-'0'))+carry;
			carry = digit/2;
			digit = digit%2;
			res.append(digit); //the higher digit will append later; so need reverse at the end
			i--;
			j--;
		}
		while(i>=0){
			int digit = (int)(a.charAt(i)-'0')+carry;
			carry = digit/2;
			digit = digit%2;
			res.append(digit); 
			i--;
		}
		while(j>=0){
			int digit = (int)(b.charAt(j)-'0')+carry;
			carry = digit/2;
			digit = digit%2;
			res.append(digit); 
			j--;
		}
		//never forget carry!
		if(carry>0){
			res.append(carry);
		}
		//reverse res
		return res.reverse().toString();
	}
}
