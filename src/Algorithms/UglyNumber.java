package Algorithms;

/**
 * Created by yuhuazh on 9/13/2015.
 */
public class UglyNumber {
    public boolean isUgly(int num) {
        if(num<=0) return false;
        int[] dividors = {2,3,5};
        for(int i=0;i<dividors.length;i++){
            int d=dividors[i];
            int r=0;
            while(num>1){
                r=num%d;
                if(r==0){
                    num=num/d;
                }
                else{
                    break;
                }
            }
            if(num<=1){
                break;
            }
        }
        return num==1;
    }
}
