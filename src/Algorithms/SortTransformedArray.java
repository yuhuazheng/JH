/**
 * Created by yuhua on 18/06/16.
 */
public class SortTransformedArray {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        if(nums==null||nums.length==0) return (new int[0]);
        int[] res = new int[nums.length];
        int l=0;
        int r=nums.length-1;
        int idx = a>=0? nums.length-1:0;
        while(l<=r){
            if(a>=0){
                res[idx--]=cal(nums[l], a, b, c) >= cal(nums[r], a, b, c) ? cal(nums[l++], a, b, c) : cal(nums[r--], a, b, c);
            }
            else{
                res[idx++]=cal(nums[l], a, b, c) <= cal(nums[r], a, b, c) ? cal(nums[l++], a, b, c) : cal(nums[r--], a, b, c);
            }
        }
        return res;
    }

    private int cal(int x, int a, int b, int c){
        return a*x*x+b*x+c;
    }
}
