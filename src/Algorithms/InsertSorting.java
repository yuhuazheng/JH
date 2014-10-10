package Algorithms;

import java.lang.*;

public class InsertSorting {

	public static void main(String[] args){
		int[] inputs = {1,3,5,4,11,55,66,22};
		
		for(int j=1;j<inputs.length; j++){
			for(int i=0;i<j;i++){
				if(inputs[j]>=inputs[i]){
					continue;
				}
				else{
					int temp = inputs[j];
					inputs[j] = inputs[i];
					inputs[i] = temp;
				}
			}
		}
		
		for(int k:inputs){
			System.out.print(k);
			System.out.print(",");
		}
	}
}
