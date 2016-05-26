package Algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuhua on 3/10/16.
 */
public class UglyNumberII {

    public int nthUglyNumber(int n) {
        //ugly numbers are sequences where each one is multiplication of a factor with a previous ugly number.
        //2*1,2*2,2*3,2*4...
        //3*1,3*2,3*3,3*4...
        //each factor has a sequence
        //pick min from all factor sequences (like heap), each sequence updates itself
        if(n==1) return 1;
        int[] factors = {2,3,5};
        int size = factors.length;
        int[] index = new int[size]; //each sequence, what is the previous ugly number for it
        int[] uglynums = new int[n]; //store ugly number
        uglynums[0]=1;
        int count=0;

        while(count<n-1){
            findNextUgly(factors, index, uglynums,++count);
        }
        return uglynums[n-1];
    }

    private void findNextUgly(int[] factors, int[] index, int[] uglynums, int count){
        int n = factors.length;
        int minVal = Integer.MAX_VALUE;
        int[] candidates = new int[n];
        for(int i=0;i<n;i++){
            candidates[i]=uglynums[index[i]]*factors[i]; //how each sequence is made of: an uglynumber * factor
            minVal = Math.min(minVal,candidates[i]);
        }
        for(int i=0;i<n;i++){
            if(candidates[i]==minVal){
                index[i]++;
            }
        }
        uglynums[count]=minVal;
    }

    public static void main(String[] args){
        UglyNumberII inst = new UglyNumberII();
        System.out.println(inst.nthUglyNumber(6));
    }
}
