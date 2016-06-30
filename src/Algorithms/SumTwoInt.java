/**
 * Created by yuhuazh on 6/29/2016.
 */
public class SumTwoInt {
    public int getSum(int a, int b) {
        int sum=0;
        int carry=0;
        for(int i=0;i<32;i++){
            int n1=(a>>i)&1;
            int n2=(b>>i)&1;
            if(n1==1&&n2==1){
                if(carry==0){
                    carry=1;
                }
                else{
                    sum=sum|1<<i;
                }
            }
            else if(n1==1||n2==1){
                if(carry==0){
                    sum=sum|1<<i;
                }
            }
            else{
                if(carry==1){
                    sum=sum|1<<i;
                    carry=0;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        SumTwoInt inst = new SumTwoInt();
        System.out.println(inst.getSum(1,2));
    }
}
