package Algorithms;

public class ZigzagConversion {

	public static void main(String[] args){
		ZigzagConversion helper = new ZigzagConversion();
		System.out.println(helper.convert("PAYPALISHIRING", 3));
	}
	
	public String convert(String s, int nRows) {
		if(s==null||s.length()<1||nRows<1){
			return null;
		}
		if(nRows==1){
			return s;
		}
		StringBuilder res = new StringBuilder();
		int cycle = 2*nRows-2;
		for(int i=0;i<nRows;i++){
			for(int j=i;j<s.length();j+=cycle){
				res.append(s.charAt(j));
				if(i!=0&&i!=nRows-1){
					int temp=j+cycle-2*i; //go to next cycle, backwards along with i
					if(temp<s.length()){
						res.append(s.charAt(temp));
					}
				}
			}
		}
		return res.toString();
	}
}
