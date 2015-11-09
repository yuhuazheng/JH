package Algorithms;

/**
 * Created by yuhuazh on 10/27/2015.
 */
public class OneEditDistance2 {

    public boolean isOneEditDistance(String s, String t) {
        if((s==null && t==null)
           || (s.length()==0&&t.length()==0)
                )
            return true;

        if((s.length()==1&&t.length()==0)
            || (t.length()==1&&s.length()==0)
                )
            return true;

        //make s is longer than t
        if(t.length()>s.length()){
            String temp = s;
            s=t;
            t=temp;
        }

        String sNext="";
        if(s.length()>1){
            sNext = s.substring(1);
        }
        String tNext="";
        if(t.length()>1){
            tNext = t.substring(1);
        }

        if(s.length()>1 && isOneEditDistance(sNext,t))
        {
            return true;
        }
        else if (s.charAt(0)==t.charAt(0)&& isOneEditDistance(sNext,tNext)){
            return true;
        }
        return false;
    }
}
