package Algorithms;

import java.util.ArrayList;

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
        int[] candidates = factors.clone(); //sequences
        int[] uglynums = new int[n]; //store ugly number
        uglynums[0]=1;
        int count=0;
        ArrayList<Integer> minCandIndex = new ArrayList<>();

        while(count<n-1){
            count++;
            //find min candidates
            minCandIndex.clear();
            uglynums[count] = findMinIndex(candidates, minCandIndex);
            //udpate index and candiates
            for(int i : minCandIndex){ //ith factor
                //move index to current location in uglynums for this factor
                index[i]++;
                //find next candiddate for this factor
                int uglyBase = uglynums[index[i]];
                int factorVal = factors[i];
                candidates[i] = uglyBase*factorVal;
            }
        }
        return uglynums[n-1];
    }

    private int findMinIndex(int[] candidates, ArrayList<Integer> minIndex){
        int minVal = candidates[0];
        int curVal = minVal;
        minIndex.add(0);
        for(int i=1;i<candidates.length;i++){
            curVal = candidates[i];
            if(curVal==minVal)
                minIndex.add(i);
            if(curVal<minVal) {
                minIndex.clear();
                minIndex.add(i);
                minVal=curVal;
            }
        }
        return minVal;
    }

    public static void main(String[] args){
        UglyNumberII inst = new UglyNumberII();
        System.out.println(inst.nthUglyNumber(6));
    }
}
