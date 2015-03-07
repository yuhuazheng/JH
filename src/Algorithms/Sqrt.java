package Algorithms;

public class Sqrt {

	public int sqrt(int x) {
		if(x<0){
			return -1;
		}
		if(x==0){
			return 0;
		}
		if(x==1){
			return 1;
		}
		int l=1;
		int r=x;
		int m=0;
		while(l<=r){
			m=(l+r)/2;
			if(m<=x/m && m+1>x/(m+1)){
				return m;
			}
			else if(m>x/m){
				r=m;
			}
			else{
				l=m;
			}
		}
		return 0;
	}
}
