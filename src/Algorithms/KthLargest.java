/**
 * Created by yuhuazh on 8/7/2016.
 */
public class KthLargest {
    public int findKthLargest(int[] nums, int k) {
        return dnc(nums,0,nums.length-1,k);
    }

    private int dnc(int[] nums,int start,int end, int k){
        if(start==end&&k==1) return nums[start];
        int pivot = nums[end];
        int l=start;
        int r=end;
        while(l<r){
            while(l<r && nums[l]>pivot){
                l++;
            }
            if(l<r){
                nums[r]=nums[l];
            }
            while(l<r && nums[r]<=pivot){
                r--;
            }
            if(l<r){
                nums[l]=nums[r];
            }
        }
        nums[l]=pivot;
        int rank = (l-start+1);
        if(rank==k) return pivot;
        if(rank<k)
            return dnc(nums,l+1,end,k-rank);
        else
            return dnc(nums,start,l-1,k);
    }

    public static void main(String[] args) {
        KthLargest inst = new KthLargest();
        int[] nums = {5,2,4,1,3,6,0};
        int k=4;
        int res = inst.findKthLargest(nums,k);
        System.out.println(res);
    }
}
