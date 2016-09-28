
import java.util.Arrays;

public class SortColors {

	public static void main(String[] args){
		int[] A ={1,0};
		sortColors(A);
		System.out.println(Arrays.toString(A));
	}
	
	public static void sortColors(int[] nums){
		if(nums==null||nums.length<=1)
			return;

		int red=-1;
		int white=-1;
		int blue=-1;
		for(int i=0;i<nums.length;i++){
			int v=nums[i];
			if(v==2){
				if(blue<0){
					if(red>=0)
						blue=red;
					if(white>=0)
						blue=white;
				}
				nums[++blue]=2;
			}
			else if(v==1){
				if(white<0){
					if(red>=0)
						white=red;
				}
				nums[++white]=1;
				if(blue>=0)
					nums[++blue]=2;
			}
			else{
				nums[++red]=0;
				if(white>=0)
					nums[++white]=1;

				if(blue>=0)
					nums[++blue]=2;
			}
		}
	}
}
