/**
 * Created by yuhua on 29/06/16.
 */
public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        if(num==0||num==1) return true;

        int l=1;
        int r=num/2+1;
        while(l<=r){
            int m=(l+r)/2;
            if(m>Integer.MAX_VALUE/m){
                r=m-1;
                continue;
            }
            long temp = m*m;
            if(temp==num){
                return true;
            }
            else if(temp>num){
                r=m-1;
            }
            else{
                l=m+1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ValidPerfectSquare inst = new ValidPerfectSquare();
        System.out.println(inst.isPerfectSquare(808201));
    }
}
