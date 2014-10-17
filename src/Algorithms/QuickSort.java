package Algorithms;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args){
		int[] inputs = {1,3,4,2,11,7};
		int[] outputs = Qsort(inputs,0,inputs.length-1);
		System.out.println(Arrays.toString(outputs));
	}
	
	public static int[] Qsort(int[] inputs, int start, int end){
		if(inputs==null || inputs.length<1){
			return null;
		}
		
		int[] outputs = inputs.clone();
		if(outputs.length==1){
			return outputs;
		}
		else if(outputs.length==2){
			if(outputs[0]>outputs[1]){
				Swap(outputs,0,1);
			}
			return outputs;
		}
		else if(start == end){
			return outputs;
		}
		else if(start+1 == end){
			if(outputs[start]>outputs[end]){
				Swap(outputs,start,end);
			}
			return outputs;
		}
		else{
			int pivot = outputs[start+(end-start)/2];
			int Lidx = start;
			int Ridx = end;
			while(Ridx>Lidx){
				if(outputs[Lidx]<pivot){
					Lidx++;
					continue;
				}
				else{
					Swap(outputs,Lidx,Ridx);
					Ridx--;
					continue;
				}
			}
			if(Lidx>=end){
				outputs=Qsort(outputs,start,end-1);
			}
			else if(Ridx<=start){
				outputs=Qsort(outputs,start+1,end);
			}
			else{
				outputs=Qsort(outputs,start,Lidx);
				outputs=Qsort(outputs,Lidx+1,end);
			}
			return outputs;
		}
	}
	
	public static void Swap(int[] array, int i, int j){
		if(array!=null || array.length>=Math.max(i, j)){
			int temp = array[i];
			array[i] = array[j];
			array[j] = temp;
		}
	}
}
