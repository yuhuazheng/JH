package Algorithms;

public class AddBinary {

	public static void main(String[] args){
		String a="110010";
		String b="10111";
		AddBinary helper = new AddBinary();
		System.out.println(helper.addBinary(a, b));
	}
	
	public String addBinary(String a, String b) {
		if(a==null||b==null){
			return null;
		}
		
		if(a==""){
			return b;
		}
		if(b==""){
			return a;
		}
		
		//make a.length >b.length
		if(b.length()>a.length()){
			String temp=a;
			a=b;
			b=temp;
		}
		
		char[] c= new char[a.length()+1];
		int i=a.length()-1;
		int j=b.length()-1;
		int k=c.length-1;
		boolean carry=false;
		while(j>=0){
			if(a.charAt(i)=='1'&&b.charAt(j)=='1'){
				if(carry){
					c[k]='1';
				}
				else{
					c[k]='0';
					carry=true;
				}
			}
			else if(a.charAt(i)=='0'&&b.charAt(j)=='0'){
				if(carry){
					c[k]='1';
					carry=false;
				}
				else{
					c[k]='0';
				}
			}
			else{
				if(carry){
					c[k]='0';
					carry=true;
				}
				else{
					c[k]='1';
				}
			}
			i--;
			j--;
			k--;
		}
		while(i>=0){
			if(a.charAt(i)=='0'){
				if(carry){
					c[k]='1';
					carry=false;
				}
				else{
					c[k]='0';
				}
			}
			else{
				if(carry){
					c[k]='0';
				}
				else{
					c[k]='1';
					carry=false;
				}
			}
			i--;
			k--;
		}
		if(carry){
			c[0]='1';
			return String.valueOf(c);
		}
		else{
			c[0]='0';
			return String.valueOf(c).substring(1);
		}
	}
}
