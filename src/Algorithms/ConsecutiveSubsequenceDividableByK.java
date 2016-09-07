/**
 * Created by yuhuazh on 8/23/2016.
 */
public class ConsecutiveSubsequenceDividableByK {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int[] nums = {1,2,1,2,1,2};
        int k=2;
        System.out.println(countSubArray(nums,k));
    }

    private static int countSubArray(int[] nums, int k){
        int[] buf = new int[k];
        int sum = 0;
        for(int n: nums){
            sum+=n;
            int residual = sum%k;
            buf[residual]++;
        }

        int count = buf[0];
        for(int i=0;i<k;i++){
            count+= (buf[i]*(buf[i]-1))/2;
        }
        return count;
    }
}
