import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by yuhua on 15/06/16.
 */
public class MaxRectangle {
    public int maximalRectangle(char[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0) return 0;
        int m=matrix.length;
        int n=matrix[0].length;

        int[][] heights = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='0'){
                    heights[i][j]=0;
                }
                else{
                    heights[i][j]=i==0?1:heights[i-1][j]+1;
                }
            }
        }

        int maxArea=0;
        for(int i=0;i<m;i++){//max hist for each row
            Stack<Integer> stk = new Stack<>();
            int j=0;
            while(j<n){
                if(stk.isEmpty()|| heights[i][j]>=heights[i][stk.peek()]){
                    stk.push(j);
                    j++;
                }
                else{
                    int h = heights[i][stk.pop()];
                    int w = stk.isEmpty()?j:(j-stk.peek()-1);
                    maxArea=Math.max(maxArea,h*w);
                }
            }
            while(!stk.isEmpty()){
                int h = heights[i][stk.pop()];
                int w = stk.isEmpty()?j:(n-stk.peek()-1);
                maxArea=Math.max(maxArea,h*w);
            }
        }
        return maxArea;
    }
}
