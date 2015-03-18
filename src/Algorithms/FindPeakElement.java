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
		return helper(num,0,num.length-1);
	}
	
	private int helper(int[] num, int l, int r){
		if(r<l){
			return -1;
		}
		
		int m=(l+r)/2;
		// m and m+1 will be the test targets
		// given num[-1] and num[n] as special case, we should treat m with 3 cases:
		// left end, right end, and middle.
		//left end, either found, or go to the right
		//right end, either found, or go to the left
		//middle, also need to check boundary, and then recursive.
		if(m==0){
			if(num[m]>num[m+1]){
				return 0;
			}
			return helper(num,m+1,r);
		}
		else if(m==num.length-1){
			if(num[m]>num[m-1]){
				return num.length-1;
			}
			return helper(num,l,m-1);
		}
		else{
			if(num[m]<num[m+1]){
				if( (m+2>num.length-1) || (m+2<num.length && num[m+1]>num[m+2])){
					return m+1;
				}
			}
			else{
				if( (m-1<0) || (m-1>=0 && num[m]>num[m-1]) ){
					return m;
				}
			}
			return Math.max(helper(num,m+1,r), helper(num,l,m-1));
		}
	}
}
