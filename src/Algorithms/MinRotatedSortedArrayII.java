package Algorithms;

public class MinRotatedSortedArrayII {

	public int findMin(int[] num) {
		if(num==null || num.length<1) return -1;
		int l=0;
		int r=num.length-1;
		int m=0;
		while(l<r && num[l]>=num[r]){ //duplicates, num[l]>=num[r] prevents l++ does not cross the cliff and continue
			m=(l+r)/2;
			if(num[m]>num[r]){
				l=m+1;
			}
			else if(num[m]<num[l]){
				r=m;
			}
			else{ //num[l]==num[m]==num[r], don't know which half to remove
				l++;
			}
		}
		return num[l];
	}
}
