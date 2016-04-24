package Algorithms;

/**
 * Created by yuhuazh on 10/4/2015.
 */
public class ReverseWordsII {

    public static void main(String[] args){
        String str = " ";
        ReverseWordsII inst  = new ReverseWordsII();
        System.out.println(inst.reverseWords(str));
    }

    public String reverseWords(String s) {
        if(s==null || s.length()<1) return s;

        s=s.trim();
        StringBuilder sb = new StringBuilder(s);
        sb=sb.reverse();

        StringBuilder res = new StringBuilder();
        int i=0;
        int l=i;
        while(i<sb.length()){
            if(sb.charAt(i)==' '){
                StringBuilder sub = new StringBuilder(sb.substring(l,i));
                res.append(sub.reverse());
                res.append(' ');
                while(i<sb.length()&&sb.charAt(i)==' '){
                    i++;
                }
                l=i;
            }
            i++;
        }
        StringBuilder sub = new StringBuilder(sb.substring(l,i));
        res.append(sub.reverse());
        return res.toString();
    }

}
