package Algorithms;

public class MinRotatedSortedArray {

	public int findMin(int[] num) {
	       if(num==null || num.length<1) return -1;
	       int l=0;
	       int r=num.length-1;
	       int m=0;
	       while(l<r){
	           m=(l+r)/2;
	           if(num[m]>num[r]){
	             l=m+1; //l will move towards the max, and fall over the cliff to the min; and stays there until r converges  
	           } 
	           else {
	               r=m; //if we still use r=m-1; we will cross the max and l won't fall from cliff.
	           }
	       }
	       return num[l];
	    }
}
