package Algorithms;

import java.util.Arrays;

public class HeapSort {

	public static void main(String[] args){
		int[] inputs ={4,1,3,2,16,9,10,14,8,7};
		if(Hsort(inputs)){
			System.out.println(Arrays.toString(inputs));
		}
		else{
			System.out.println("sort failed");
		}
	}
	
	public static boolean Hsort(int[] inputs){
		if(inputs==null || inputs.length<1){
			return false;
		}
		else if(inputs.length==1){
			return true;
		}
		else if(inputs.length==2){
			if(inputs[0]>inputs[1]){
				Swap(inputs,0,1);
			}
			return true;
		}
		else{
			BuildHeap(inputs);
			for(int i=inputs.length-1; i>1;i--){
				Swap(inputs,0,i);
				Heapify(inputs,0, i-1);
			}
			return true;
		}
	}
	
	//heapify from start; and the last valid item is end
	public static void Heapify(int[] inputs, int start, int end){
		
		int range = end-start;
		if(inputs==null || range<0 || start>= inputs.length || end >= inputs.length || inputs.length<(end-start)){
			return;
		}
		else if(range==1){
			if(inputs[start]>inputs[end]){
				Swap(inputs,start,end);
			}
			return;
		}
		else{
			int left = start*2;
			int right = left+1;
			int changed = start;
			
			if(left>end){
				//leave node
				return;
			}
			else if(right>end){
				if(inputs[left]>inputs[start]){
					Swap(inputs,start,left);
					changed = left;
				}
			}
			else{
				//two children
				if(inputs[left]<=inputs[right]){
					if(inputs[start]< inputs[right]){
						Swap(inputs,start,right);
						changed = right;
					}
				}
				else{
					if(inputs[start]<inputs[left]){
					Swap(inputs,start,left);
					changed = left;
					}
				}
			}
				
			if(changed != start){
				Heapify(inputs,changed,end);
			}
			return;
		}
	}
	
	public static void BuildHeap(int[] inputs){
		if(inputs==null || inputs.length<=1){
			return;
		}
		else if (inputs.length==2){
			if(inputs[0]<inputs[1]){
				Swap(inputs,0,1);
			}
			return;
		}
		else{
			for(int i=inputs.length/2-1; i>=0; i--){
				Heapify(inputs,i,inputs.length-1);
			}
		}
	}
		
	public static void Swap(int[] inputs, int i, int j){
		if(inputs==null || inputs.length<Math.max(i, j)){
			return;
		}
		else{
			int temp = inputs[i];
			inputs[i] = inputs[j];
			inputs[j] = temp;
			return;
		}
	}
}
