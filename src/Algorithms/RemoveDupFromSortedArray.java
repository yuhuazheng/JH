package myPractice;

public class RemoveDupFromSortedArray {

	public static void main(String[] main){
		int[] A = new int[3];
		RemoveDupFromSortedArray helper = new RemoveDupFromSortedArray();
		System.out.println(helper.removeDuplicates(A));
	}
	
	public int removeDuplicates(int[] A){
		if(A==null || A.length<1){
			return 0;
		}
		
		int idx=0;
		int cur=A[0];
		for(int i=1;i<A.length;i++){
			if(A[i]==cur){
				continue;
			}
			else{
				idx++;
				cur=A[i];
				A[idx]=cur;
			}
		}
		return idx+1;
	}
}
