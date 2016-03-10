package Algorithms;

public class FindPeakElement {

	public static void main(String[] args){
		int[] num = {1,2};
		FindPeakElement inst = new FindPeakElement();
		System.out.println(inst.findPeakElement(num));
	}
	
	public int findPeakElement(int[] num) {
		if(num==null || num.length<1){
			return -1;
		}
		if(num.length==1){
			return 0;
		}
		int l=0;
		int r=num.length-1;
		int m=0;
		while(l<=r){
			m = (l+r)/2;
			if( (m==0||num[m]>num[m-1])
				&&(m==num.length-1||num[m]>num[m+1])
					)
				return m;
			else if(m>0 && num[m]<num[m-1]) //m-1>m, left half must has a peak
				r=m-1;				 //it either bigger than its neighbor, or be m[0].
			else
				l=m+1;
		}
		return m;
	}
}
