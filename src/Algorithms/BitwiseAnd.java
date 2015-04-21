package Algorithms;

public class BitwiseAnd {

	public int rangeBitwiseAnd(int m, int n) {
		if(m<0||n<0){
			return 0;
		}
		int p=m;
		int q=n;
		int count=0;
		while(p!=q){
			p=p>>1;
			q=q>>1;
			count++;
		}
		return p<<count;
	}
}
