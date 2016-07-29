/**
 * Created by yuhuazh on 7/29/2016.
 */
public class SumTwoIntegers {
    public int getSum(int a, int b) {
        int carry=0;
        int res=0;
        for(int i=0;i<32;i++){
            int mask = 1<<i;
            int v1=a&mask;
            int v2=b&mask;
            if(v1!=0&&v2!=0){
                if(carry==1)
                    res|=mask;
                carry=1;
            }
            else if(v1!=0||v2!=0){
                if(carry==0)
                    res|=mask;
            }
            else{
                if(carry==1){
                    res|=mask;
                    carry=0;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SumTwoIntegers inst = new SumTwoIntegers();
        System.out.println(inst.getSum(1,2));
    }
}
