package myPractice;

import java.util.Arrays;

public class UniquePaths {

	public static void main(String[] args){
		UniquePaths helper = new UniquePaths();
		System.out.println(helper.uniquePaths(3,3));
	}
	
	public int uniquePaths(int m, int n){
		if(m<1||n<1){
			return 0;
		}
		
		int[] buffer = new int[n];
		Arrays.fill(buffer, 1);
		for(int i=2;i<=m;i++){
			for(int j=1;j<n;j++){
				buffer[j]=buffer[j-1]+buffer[j];
			}
		}
		return buffer[n-1];
	}
}
