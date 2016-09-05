/**
 * Created by yuhua on 04/09/16.
 */
public class CountInversion {
    public int inversion(int[] nums){
        if(nums==null||nums.length==0) return 0;
        int[] buf = new int[nums.length];
        return merge(nums,buf,0,nums.length-1);
    }

    private int merge(int[] nums,int[] buf, int l, int r){
        if(l==r) return 0;
        int m = l+(r-l)/2;
        int count=0;
        count=merge(nums,buf,l,m);
        count+=merge(nums,buf,m+1,r);
        count+=mergeTwo(nums,buf,l,m,r);
        return count;
    }

    private int mergeTwo(int[] nums,int[] buf,int l,int m,int r){
        int i=l;
        int j=m+1;
        int count=0;
        int k=l;
        while(i<=m&&j<=r){
            if(nums[i]<=nums[j])
                buf[k++]=nums[i++];
            else{
                buf[k++]=nums[j++];
                count+=m+1-i;
            }
        }
        while(i<=m)
            buf[k++]=nums[i++];
        while(j<=r)
            buf[k++]=nums[j++];
        for(i=l;i<=r;i++)
            nums[i]=buf[i];
        return count;
    }

    public static void main(String[] args) {
        CountInversion inst = new CountInversion();
        //int[] nums = {8,4,2,1};
        int[] nums = {2,4,1,3,5};
        System.out.println(inst.inversion(nums));
    }
}
