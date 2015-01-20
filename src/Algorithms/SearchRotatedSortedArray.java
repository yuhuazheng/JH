package Algorithms;

public class SearchRotatedSortedArray {

	public static void main(String[] args){
		int[] A={1,3};
		int target=0;
		SearchRotatedSortedArray helper = new SearchRotatedSortedArray();
		System.out.println(helper.search(A,target));
	}
	
	public int search(int[] A, int target){		
		if(A==null || A.length<1){
			return -1;
		}
		
		//although rotated, but in order to find the target, key is to locate the segment which contains it
		//so the goal is to iteratively narrow the [l,r] to contain target.
		
		int l = 0, 
		r = A.length-1;   
        while(l<=r)   
        {
        	int m = (l+r)/2;   
            if(A[m] == target) return m;   
            if(A[m]>= A[l])   
            {
            	if(A[l]<=target && target<= A[m])   
                      r=m-1;   
                else   
                      l = m+1;       
            }   
            else   
            {   
                if(A[m] >= target || target>= A[l])   
                     r = m-1;    
                else   
                      l = m+1;   
            }   
        }   
        return -1;   
   }   
}
