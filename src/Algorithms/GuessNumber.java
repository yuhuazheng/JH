/**
 * Created by yuhuazh on 7/14/2016.
 */
public class GuessNumber {

    int num=1702766719;

    public int guessNumber(int n) {
        if(n==1) return 1;
        int low=0;
        int high=n;
        while(low<high){
            int m=low+(high-low)/2;
            int r = guess(m);
            if(r==0){
                return m;
            }
            else if(r==-1){
                high=m-1;
            }
            else{
                low=m+1;
            }
        }
        return low;
    }

    public int guess(int m){
        if(m==num)
            return 0;
        if(m<num)
            return 1;
        return -1;
    }

    public static void main(String[] args) {
        GuessNumber inst = new GuessNumber();
        System.out.println(inst.guessNumber(2126753390));
    }
}
