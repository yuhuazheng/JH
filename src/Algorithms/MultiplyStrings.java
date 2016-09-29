
public class MultiplyStrings {

	public static void main(String[] args){
		String num1="98";
		String num2="9";
		MultiplyStrings helper = new MultiplyStrings();
		System.out.println(helper.multiply(num1, num2));
	}
	
	public String multiply(String num1, String num2) {
		if((num1==null||num1.length()==0||num1.equals("0"))||(num2==null||num2.length()==0||num2.equals("0")))
			return "0";

		int m=num1.length();
		int n=num2.length();
		int[] res = new int[m+n];
		for(int i=m-1;i>=0;i--){
			int v1=num1.charAt(i)-'0';
			for(int j=n-1;j>=0;j--){
				int v2=num2.charAt(j)-'0';
				int r = v1*v2;
				int idx = m-1-i+n-1-j;
				res[idx]+=r%10;
				if(res[idx]>9){
					int carry = res[idx]/10;
					res[idx]=res[idx]%10;
					res[idx+1]+=carry;
				}
				res[idx+1]+=r/10;
				if(res[idx+1]>9){
					int carry = res[idx+1]/10;
					res[idx+1]=res[idx+1]%10;
					res[idx+2]+=carry;
				}
			}
		}

		int k=m+n-1;
		if(res[k]==0)
			k--;
		StringBuilder sb = new StringBuilder();
		while(k>=0){
			sb.append(res[k--]);
		}
		return sb.toString();
	}
}
