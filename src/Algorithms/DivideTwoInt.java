
public class DivideTwoInt {

	public static void main(String[] args){
		int dividend=-1;
		int divisor=1;
		DivideTwoInt helper = new DivideTwoInt();
		System.out.println(helper.divide(dividend, divisor));
	}
	
	public int divide(int dividend, int divisor) {
		if(divisor == 0)
	    {
	        return Integer.MAX_VALUE;
	    }
	    boolean isNeg = (dividend^divisor)>>>31 == 1;
	    int res = 0;
	    if(dividend == Integer.MIN_VALUE)
	    {
	        dividend += Math.abs(divisor);
	        if(divisor == -1)
	        {
	            return Integer.MAX_VALUE;
	        }
	        res++;
	    }
	    if(divisor == Integer.MIN_VALUE)
	    {
	        return res;
	    }
	    dividend = Math.abs(dividend);
	    divisor = Math.abs(divisor);
	    int digit = 0;
	    //dividend = divisor(a0*2^0+a1*2^1+...+an*2^n); a0,a1,..., an are either 0 or 1
		//64=3*21=3*(1+4+16)
		while(divisor <= (dividend>>1))
	    {
	        divisor <<= 1;
	        digit++;
	    }
	    while(digit>=0)
	    {
	        if(dividend>=divisor)
	        {
	            res += 1<<digit;
	            dividend -= divisor;
	        }
	        divisor >>= 1;
	        digit--;
	    }
	    return isNeg?-res:res;
	}
}
