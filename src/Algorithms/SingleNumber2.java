package Algorithms;

public class SingleNumber2 {

	public static void main(String[] args){
		int[] A = {0,0,0,5};
		SingleNumber2 helper = new SingleNumber2();
		System.out.println(helper.singleNumber(A));
	}
	public int singleNumber(int[] A) {
		if(A==null || A.length<1){
			return 0;
		}
		int[] res=new int[32];
		for(int i=0;i<A.length;i++){
			for(int j=0;j<32;j++){
				res[j]+=(A[i]>>j)&1;
			}
		}
		int value=0;
		for(int l=0;l<32;l++){
			value += (res[l]%3)<<l;
		}
		return value;
	}
}
