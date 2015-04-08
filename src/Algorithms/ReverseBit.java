package Algorithms;

public class ReverseBit {

	public static void main(String[] args){
		ReverseBit helper = new ReverseBit();
		int n = -1;
		//int n = 1;
		System.out.println(helper.reverseBits(n));
		return;
	}
	
	public int reverseBits(int n) {
		int res=0;
		for(int i=0;i<=31;i++){
			int digit = (n>>i)&1;
			res = res | digit<<(31-i);
		}
		return res;
	}
}
