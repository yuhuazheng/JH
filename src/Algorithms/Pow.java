package Algorithms;

public class Pow {

	public static void main(String[] args){
		double x=2.0;
		int n=-2147483648;
		Pow helper = new Pow();
		System.out.println(helper.pow(x, n));
	}

	public double pow(double x, int n) {
		if(n==0) return 1.0;
		if(n>0) return powPositive(x,n);
		else{
			if(n>Integer.MIN_VALUE) {
				return 1 / powPositive(x, -n);
			}
			else{
				return x/powPositive(x,-(n+1));
			}
		}
	}

	private double powPositive(double x, int n){
		if(n==0) return 1;
		double halfRes = powPositive(x,n/2);
		double res = halfRes*halfRes;
		if(n%2==1) res*=x;
		return res;
	}

	/*public double pow(double x, int n) {
		if(n==0){
			return 1.0;
		}
		
		//x==1.00 or -1.00 seems to be special case; however double is hard to use ==; so no special case.
		
		double res=1.0;
		
		//convert n<0 into n>0 so that only consider half
		if(n<0){
			//x<=max or x>=min; however double computation has limited accuracy;
			//so if x is extremely small, less than 1.0/max_value in computation
			//1.0/x will bigger than max_value, and overflow
			if(x>=1.0/Double.MAX_VALUE || x<=1.0/Double.MIN_VALUE){
				x=1.0/x;
			}
			else{
				return Double.MAX_VALUE;
			}
			//this is for later Math.abs(n), which doesn't work for n==min_value
			if(n==Integer.MIN_VALUE){
				res*=x;
				n++;
			}
		}
		
		//sign of the result
		n=Math.abs(n);
		boolean isNeg=false;
		if((n%2==1)&&(x<0)){
			isNeg=true;
		}
		x=Math.abs(x);
		//use bit operation, 2^4 = (2^2)^2, everytime left-move 1-bit of x and right-move 1-bit of n
		while(n>0){
			if((n&1)==1){
				//if current bit is 1, multiply
				if(res>Double.MAX_VALUE/x){ //can't do res*x>max_value, LHS will already overflow
					return Double.MAX_VALUE;
				}
				else{
					res*=x;
				}
			}
			x*=x;
			n=n>>1;
		}
		
		return isNeg?-res:res;
	}*/
}
