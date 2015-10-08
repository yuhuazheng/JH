package Algorithms;

/**
 * Created by yuhuazh on 10/4/2015.
 */
public class ReverseWordsII {

    public static void main(String[] args){
        String str = "a b";
        ReverseWordsII inst  = new ReverseWordsII();
        char[] s = str.toCharArray();
        inst.reverseWords(s);
        System.out.println(s);
    }

    public void reverseWords(char[] s) {
        if(s==null || s.length<=1) return;

        reverse(s,0,s.length-1);
        int l=0;
        int r=0;
        for(int i=1;i<s.length;i++){
            if(s[i]==' '){
                reverse(s,l,r);
                l=i+1;
                r=l;
                i++;
            }
            else{
                r++;
            }
        }
        reverse(s,l,r);
    }

    private void reverse(char[] s, int l, int r){
        while(l<r){
            char temp = s[l];
            s[l]=s[r];
            s[r]=temp;
            l++;
            r--;
        }
    }
}
