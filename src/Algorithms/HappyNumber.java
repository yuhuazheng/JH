
import java.util.HashSet;

public class HappyNumber {

	public static void main(String[] args){
		HappyNumber inst = new HappyNumber();
		System.out.println(inst.isHappy(4));
	}
	
	public boolean isHappy(int n) {
		if(n<=0){
			return false;
		}
		HashSet<Integer> pre=new HashSet<Integer>();
		int cur=n;
		int sum=n;
		while(sum!=1 && !pre.contains(sum)){
			cur=sum;
			pre.add(sum);
			sum=0;
			while(cur/10>0 || cur%10!=0){
				int temp = cur%10;
				cur = cur/10;
				sum+=temp*temp;
			}
		}
		if(sum==1){
			return true;
		}
		return false;
	}
}
