package EA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by yuhua on 11/10/15.
 */
public class MaxSubarray2DCircular {

    public static void main(String[] args) throws IOException{
        //load the data
        FileInputStream fstream = new FileInputStream("/home/yuhua/workspace/Algorithms/src/EA/test.txt");
        //FileInputStream fstream = new FileInputStream(args[0]);
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        String headLine = br.readLine();
        String[] size = headLine.split(" ");
        int r=Integer.parseInt(size[0]);
        int c=Integer.parseInt(size[1]);
        int[][] data1 = new int[r][c];

        for(int i=0;i<r;i++){
            String valueLine = br.readLine();
            String[] values = valueLine.split(" ");
            for(int j=0;j<c;j++){
                data1[i][j] = Integer.parseInt(values[j]);
            }
        }

        //check data

        int[][] data = {
                {8,-9,2,5,6,-3},
                {0,-3,-5,1,-12,20},
                {6,7,-1,-9,-7,-3},
                        };
        /*
        int[][] data = {
                {5,6,-3,8,-9,2},
                {1,-12,20,0,-3,-5},
                {-9,-7,-3,6,7,-1},
        };*/
        //expand data
        int[][] expandData = new int[data.length][];
        for(int i=0; i<data.length;i++){
            int[] temp = Arrays.copyOfRange(data[i],0,c-1);
            expandData[i] = new int[2*c-1];
            System.arraycopy(data[i],0,expandData[i],0,c);
            System.arraycopy(temp,0,expandData[i],c,c-1);
        }

        //find max 2d subarray
        MaxSubarray2DCircular inst = new MaxSubarray2DCircular();
        int[] maxRes = new int[5];
        inst.find2DMaxSubarray(expandData, c, maxRes);
        System.out.println("Sum: " + maxRes[0]);
        System.out.println("TopLeftIndex: "+maxRes[1]%r+", "+maxRes[2]%c);
        System.out.println("BottomRightIndex: "+maxRes[3]%r+", "+maxRes[4]%c);
    }

    private void find2DMaxSubarray(int[][] matrix, int maxCol, int[] maxRes){ //res[5]:sum,toprow,leftcolumn,bottomrow,rightcolumn
        int row = matrix.length;
        int col = matrix[0].length;

        //iterate all possible left column
        for (int left = 0; left < col; left++)
        {
            int[] temp = new int[row]; //to hold 1d array
            //iterate all possible right column
            for (int right = left; right < Math.min(col,left+maxCol); right++)
            {
                //covert the 2d subarray between left and right column into a 1d array
                for (int i = 0; i < row; ++i) {
                    temp[i] += matrix[i][right];
                }

                // Find the max 1d subarray in temp[].
                int[] curRes = new int[3];
                findMaxSubarray(temp,curRes);
                if(curRes[0]>maxRes[0]){ //find a new max
                    maxRes[0]=curRes[0];
                    maxRes[1]=curRes[1];
                    maxRes[2]=left;
                    maxRes[3]=curRes[2];
                    maxRes[4]=right;
                }
            }
        }

        return;
    }

    private void findMaxSubarray(int[] A, int[] res){ //res[3]: sum, toprow,bottomerow
        //find 1D max subarray
        if(A==null || A.length<1){
            return;
        }

        int global = A[0];
        int local = A[0];
        int top=0;
        int bottom=0;
        for(int i=1;i<A.length;i++){
            if(A[i]>local+A[i]){
                top=i;
                bottom=i;
            }
            else{
                bottom=i;
            }
            local = Math.max(A[i], local+A[i]);

            if(local>global){
                res[0]=local;
                res[1]=top;
                res[2]=bottom;
            }
            global = Math.max(global,local);
        }
        return;
    }
}
