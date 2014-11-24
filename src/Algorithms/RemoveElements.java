package Algorithms;

import java.util.Arrays;

public class RemoveElements {

	public static void main(String[] args){
		int[] A={3,3};
		int elem=3;
		System.out.println(removeElement(A,elem));
	}
	
	public static int removeElement(int[] A, int elem) {
		if(A==null){
			return 0;
		}
		else if(A.length==1){
				if(A[0]==elem){
					A=null;
					return 0;
				}
				else{
					return 1;
				}
		}
		else{
			int i=0;
			int j=-1;
			while(i<A.length){
				if(A[i]!=elem){
					A[++j]=A[i];
				}
				i++;
			}
			return j+1;
		}
	}
}
