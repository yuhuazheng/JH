package Algorithms;

import java.util.Arrays;

public class RemoveDupFromSortedArray {

	public static void main(String[] args){
		int[] array={1,1,2};
		System.out.println(removeDuplicates(array));
	}
	
	public static int removeDuplicates(int[] A) {
		if(A==null || A.length<1){
			return 0;
		}
		else if(A.length==1){
			return 1;
		}
		else{
			int i=0;
			int j=1;
			
			while(i<A.length && j<A.length){
				if(A[i]==A[j]){
					//another dup
					j++;
				}
				else{
					i++;
					A[i]=A[j];
					j++;
				}
			}
			A=Arrays.copyOf(A, i+1);
			return i+1;
		}
	}
}
