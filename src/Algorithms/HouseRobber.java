
public class HouseRobber {
    public int rob(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0],nums[1]);

        int pre2=nums[0];
        int pre1=Math.max(nums[1],pre2);
        int maxM=pre1;
        for(int i=2;i<nums.length;i++){
            maxM = Math.max(pre1,pre2+nums[i]); // don't rob i, equals pre1; robi, plus pre2
            pre2=pre1;
            pre1=maxM;
        }
        return maxM;
    }
}
