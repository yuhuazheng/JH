package Algorithms;

public class UniqueBST {

	public static void main(String[] args){
		int n=4;
		UniqueBST helper = new UniqueBST();
		System.out.print(helper.numTrees(n));
	}
	
	public int numTrees(int n) {
		if(n<1){
			return 0;
		}
		//c0=1; c(n+1)=sum(c(i)*c(n-i)), i=0...n
		
		int[] results = new int[n+1];
		results[0]=1;
		results[1]=1;
		for(int i=2; i<=n; i++){
			for(int j=0; j<i;j++){
				results[i]+=results[j]*results[i-j-1];
			}
		}
		return results[n];
	}
}
