package Algorithms;

/**
 * Created by yuhua on 9/17/15.
 */
public class FirstBadVersion {

    public static void main(String[] args){
        FirstBadVersion inst = new FirstBadVersion();
        System.out.println(inst.firstBadVersion(2126753390));
    }

    public boolean isBadVersion(int m){
        return m>=1702766719;
    }

    public int firstBadVersion(int n) {
        int l=1;
        int r=n;
        while(l<r){
            int m=l+(r-l)/2;
            if(isBadVersion(m)){
                r=m;
            }
            else{
                l=m+1;
            }
        }
        return l;
    }
}
