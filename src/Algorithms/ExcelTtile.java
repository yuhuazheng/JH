package Algorithms;

public class ExcelTtile {

	public static void main(String[] args){
		ExcelTtile helper = new ExcelTtile();
		System.out.println(helper.convertToTitle(1));
	}
	
	public String convertToTitle(int n) {
		if(n<=0){
			return "";
		}
		
		StringBuilder res = new StringBuilder();
		int base=26;
		int residual=0;
		while(n>0){
			n--;
			residual = n%base;
			res.append(Character.toChars(residual+'A'));
			n /= base;
		}
		return res.reverse().toString();
	}
}
