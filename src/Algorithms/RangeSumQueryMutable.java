package Algorithms;

/**
 * Created by yuhuazh on 4/26/2016.
 */
public class RangeSumQueryMutable {

    int[] bit;
    int[] values;

    private void updateBIT(int index, int delta){
        index++;
        while(index<bit.length) {
            bit[index] += delta;
            index += index & (-index);
        }
    }

    private int sumToIndexBIT(int i){
        int ans =0;
        while(i!=0){
            ans+=bit[i];
            i=i&(i-1);
        }
        return ans;
    }

    //public NumArray(int[] nums) {
    public RangeSumQueryMutable(int[] nums) {
        bit=new int[nums.length+1];
        values=new int[nums.length+1];
        for(int i=0;i<nums.length;i++){
            values[i+1]=nums[i];
            updateBIT(i,nums[i]);
        }
    }

    void update(int i, int val) {
        updateBIT(i,val-values[i+1]);
        values[i+1]=val;
    }

    public int sumRange(int i, int j) {
        return sumToIndexBIT(j+1)-sumToIndexBIT(i);
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5};
        RangeSumQueryMutable inst = new RangeSumQueryMutable(nums);
        System.out.println(inst.sumRange(0, 2));
        inst.update(1, 2);
        System.out.println(inst.sumRange(0, 2));
    }

}
