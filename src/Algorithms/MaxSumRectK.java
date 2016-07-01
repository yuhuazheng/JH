import java.util.TreeSet;

/**
 * Created by yuhuazh on 6/30/2016.
 */
public class MaxSumRectK {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int[][] vsum = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                vsum[i][j] = matrix[i][j];
                if (i > 0) vsum[i][j] += vsum[i-1][j];
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = i; j < matrix.length; j++) {
                TreeSet<Integer> ts = new TreeSet<Integer>();
                int sum = 0;
                for(int m = 0; m < matrix[i].length; m++) {
                    sum += vsum[j][m];
                    if (i > 0) sum -= vsum[i-1][m];
                    if (sum == k) return sum;
                    if (sum < k) max = Math.max(max, sum);
                    //if there is sum-k<=x so that the subset along column sum-x<=k.
                    Integer other = ts.ceiling(sum - k);
                    if (other != null) max = Math.max(max, sum - other);
                    ts.add(sum);
                }
            }
        }
        return max;
    }
}
