package Algorithms;

public class ClimbStairs {

	public static  void main(String[] args){
		int top=4;
		ClimbStairs helper = new ClimbStairs();
		System.out.println(helper.climbStairs(top));
	}
	
	public int climbStairs(int n) {
		if(n<0){
			return 0;
		}
		if(n<2){
			return 1;
		}
		if(n==2){
			return 2;
		}
		int curMinus2=1;
		int curMinus1=2;
		int cur=0;
		for(int i=3;i<=n;i++){
			cur=curMinus1+curMinus2;
			curMinus2=curMinus1;
			curMinus1=cur;
		}
		return cur;
	}
}
