
public class PalindromeNumber {

	public  boolean isPalindrome(int x) {
		if(x<0) return false;
		if(x>=0&&x<10) return true;
		int d=1;
		while(d<=x/10)
			d*=10;
		while(x>0){
			int v1=x/d;
			int v2=x%10;
			if(v1!=v2) return false;
			x%=d;
			x/=10;
			d/=100;
		}
		return true;
	}

	public static void main(String[] args) {
		PalindromeNumber inst = new PalindromeNumber();
		System.out.println(inst.isPalindrome(1410110141));
	}
}
