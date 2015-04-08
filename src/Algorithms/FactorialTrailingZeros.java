package Algorithms;

public class FactorialTrailingZeros {

	public static void main(String[] args){
		FactorialTrailingZeros inst = new FactorialTrailingZeros();
		System.out.println(inst.trailingZeroes(1808548329));
	}
	
	public int trailingZeroes(int n) {
		if ( n<0 ) return -1;
        int count = 0;
//        for (long i=5; n/i>=1; i*=5) { //use int will overflow
//            count += n / i;
//        } 
        
        while(n/5>=1) { //or reduce n
            count += n / 5;
            n/=5;
        }
        
        return count;
    }
}
