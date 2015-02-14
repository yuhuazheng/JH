package myPractice;

public class MultiplyStrings {

	public static void main(String[] args){
		String num1="98";
		String num2="0";
		MultiplyStrings helper = new MultiplyStrings();
		System.out.println(helper.multiply(num1, num2));
	}
	
	public String multiply(String num1, String num2) {
		if(num1==null||num1==""||num2==null||num2==""){
			return null;
		}
		if(num1.charAt(0)=='0' || num2.charAt(0)=='0'){
			return "0";
		}
		
		StringBuilder res = new StringBuilder();
		int cur=0;
		for(int i=0;i<(num1.length()+num2.length()-1);i++){
			for(int j=Math.max(0, i-num1.length()+1);j<num2.length();j++){
				if(j<=i){
					cur +=(num1.charAt(num1.length()-1-i+j)-'0')*(num2.charAt(num2.length()-1-j)-'0');
				}
				else{
					break;
				}
			}
			res.append(cur%10);
			cur=cur/10;
		}
		if(cur>0){
			res.append(cur);
		}
		return res.reverse().toString();
	}
}
