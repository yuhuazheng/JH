package myPractice;

import java.util.Arrays;

public class SortColors {

	public static void main(String[] args){
		int[] A ={1,0};
		sortColors(A);
		System.out.println(Arrays.toString(A));
	}
	
	public static void sortColors(int[] A){
		if(A==null || A.length<=0){
			return;
		}
		
		int left=0; //track color0
		int right=A.length-1; //track color2
		int front=0; //track current item
		
		int counter0=0;
		int counter1=0;
		int counter2=0;
		
		while(front<=right){
			if(A[front]==0){
				A[left]=0;
				left++;
				counter0++;
				front++;
			}
			else if(A[front]==2){
				while(front<=right && A[right]==2){
					right--;
					counter2++;
				}
				if(front<=right && A[right]==0){
					A[left]=0;
					left++;
					counter0++;
					A[right]=2;
					right--;
					counter2++;
				}
				else if(front<=right && A[right]==1){
					A[right]=2;
					right--;
					counter2++;
					counter1++;
				}
				front++;
			}
			else{
				//A[front]==1
				counter1++;
				front++;
			}
		}
		if(left<=right && right<A.length){
			Arrays.fill(A,left,right+1,1);
		}
	}
}
