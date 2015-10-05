package Algorithms;

/**
 * Created by yuhuazh on 10/4/2015.
 */
public class VerifyPreorderBST {

    public static void main(String[] args){
        //int[] preorder = {4,2,1,3,5,6};
        int[] preorder = new int[7500];
        for(int i=0;i<preorder.length;i++){
            preorder[i]=i+1;
        }
        VerifyPreorderBST inst = new VerifyPreorderBST();
        System.out.print(inst.verifyPreorder(preorder));
    }

    public boolean verifyPreorder(int[] preorder) {
        if(preorder==null || preorder.length<=1) return true;

        return helper(preorder,0,preorder.length, Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    private boolean helper(int[] suborder, int start, int end, int min, int max){
        if(suborder==null || end-start<=0) return true;

        int pivot = suborder[start];
        if(pivot<min||pivot>max) return false;

        int point = end;
        for(int i=start+1;i<end;i++){
            if(suborder[i]>pivot){
                point=i;
                break;
            }
        }

        if(helper(suborder,start+1,point,min,pivot)) {
            return helper(suborder, point, end, pivot, max);
        }
        return false;

    }
}
