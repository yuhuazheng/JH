package Algorithms;

import java.util.Arrays;

public class MergeSorting {

	public static void main(String[] args){
		int[] inputs = {1,3,2,55,34,25,9,7};
		
		if(inputs.length<=1){
			System.out.println(inputs[0]);
		}
		else{
			int[] outputs = MergeSort(inputs);
			System.out.println(Arrays.toString(outputs));
		}
	}
	
	public static int[] MergeSort(int[] inputs){
		int[] outputs = inputs;
		//check boundary
		if(inputs.length == 1){
			return outputs;
		}
		else{
			int divider = inputs.length/2;
			int[] firstHalf = Arrays.copyOfRange(inputs, 0, divider);
			int[] secondHalf = Arrays.copyOfRange(inputs, divider, inputs.length);
			int[] firstSorted = MergeSort(firstHalf);
			int[] secondSorted = MergeSort(secondHalf);
			outputs = MergeTwo(firstSorted,secondSorted);
			return outputs;
		}
		
	}
	
	public static int[] MergeTwo(int[] first, int[] second){
		
		if(first.length==0){
			return second;
		}
		if(second.length==0){
			return first;
		}
		
		int[] merged = new int[first.length+second.length];
		int firstIdx=0;
		int secondIdx=0;
		for(int i=0;i<merged.length;i++){
			if(firstIdx>=first.length){
				merged[i]=second[secondIdx++];
			}
			else if(secondIdx>=second.length){
				merged[i]=first[firstIdx++];
			}
			else if(first[firstIdx]<=second[secondIdx]){
				merged[i]=first[firstIdx++];
			}
			else{
				merged[i]=second[secondIdx++];
			}
		}
		
		return merged;
	}
}
