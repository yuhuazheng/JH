package Algorithms;

/**
 * for leetcode
 * Created by yuhua on 8/18/15.
 */
public class SingleNumber3 {

    public static void main(String[] args){
        int[] nums = {43772400,1674008457,1779561093,744132272,1674008457,448610617,1779561093,124075538,-1034600064,49040018,612881857,390719949,-359290212,-812493625,124732,-1361696369,49040018,-145417756,-812493625,2078552599,1568689850,865876872,865876872,-1471385435,1816352571,1793963758,2078552599,-1034600064,1475115274,-119634980,124732,661111294,-1813882010,1568689850,448610617,1347212898,-1293494866,612881857,661111294,-1361696369,1816352571,-1813882010,-359290212,1475115274,1793963758,1347212898,43772400,-1471385435,124075538,-1293494866,-119634980,390719949};
        SingleNumber3 inst = new SingleNumber3();
        int[] res = inst.singleNumber(nums);
        for(int j : res) {
            System.out.println(j);
        }
    }

    public int[] singleNumber(int[] nums) {
        if(nums==null || nums.length<2) return null;

        int temp1=0; //to hold the n1^n2
        for(int i : nums){
            temp1^=i;
        }

        //find a bit where n1 and n2 have different values
        int diffbit = 0;
        int j=0;
        while(j++<32){
            if((temp1&1)==1){
                break;
            }
            else{
                temp1=temp1>>1;
                diffbit++;
            }
        }

        int mask=1<<diffbit;
        int n1=0;
        int n2=0;
        for(int i : nums){
            if((i&mask)==0){
                n1^=i;
            }
            else{
                n2^=i;
            }
        }

        int[] res = new int[2];
        res[0]=n1;
        res[1]=n2;
        return res;
    }
}
