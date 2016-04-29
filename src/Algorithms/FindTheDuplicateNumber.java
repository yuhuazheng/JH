package Algorithms;

/**
 * Created by yuhuazh on 4/28/2016.
 */
public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int n=nums.length-1;
        int l=1;
        int r=n;
        while(l<=r){
            int m=l+(r-l)/2;
            int smallHalfCount=0;
            for(int i=0;i<nums.length;i++){
                if(nums[i]<=m)
                    smallHalfCount++;
            }
            if(smallHalfCount<=m){
                l=m+1;
            }
            else{
                r=m-1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        FindTheDuplicateNumber inst = new FindTheDuplicateNumber();
        int[] nums = {1,3,4,2,2};
        System.out.println(inst.findDuplicate(nums));
    }
}
