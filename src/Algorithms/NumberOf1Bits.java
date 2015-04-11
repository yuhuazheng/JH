package Algorithms;

public class NumberOf1Bits {

	public static void main(String[] args){
		NumberOf1Bits helper = new NumberOf1Bits();
		System.out.println(helper.hammingWeight(4));
	}
	
	public int hammingWeight(int n) {
		int count=0;
		int mask=1;
		for(int i=0;i<32;i++){
			mask=1<<i;
			int temp = mask&n;
			if(temp!=0){
				count++;
			}
		}
		return count;
	}
}
