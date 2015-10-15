package Algorithms;

/**
 * Created by yuhuazh on 10/14/2015.
 */
public class OneEditDistance {

    public static void main(String[] args){
        String s = "a";
        String t = "ac";
        OneEditDistance inst = new OneEditDistance();
        System.out.println(inst.isOneEditDistance(s,t));
    }

    public boolean isOneEditDistance(String s, String t) {
        if((s.length()==0&&t.length()==1)||(s.length()==1&&t.length()==0)) return true;
        if(s.length()==0&&t.length()==0) return false;

        //always make s.length>t.length
        if(s.length()<t.length()){
            String temp=s;
            s=t;
            t=temp;
        }
        if(s.length()-t.length()>1) return false;

        if(s.length()==t.length()){
            //one distance can only be replacing a char
            int change=0;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)!=t.charAt(i)) change++;
                if(change>1) return false;
            }
            return change==1;
        }
        else{
            //one distance can only be inserting a char
            int change=0;
            int i=0;
            int j=0;
            while(i<s.length()&&j<t.length()){
                if(s.charAt(i)!=t.charAt(j)){
                    change++;
                    //since s.length>t.length, insert to t
                    i++;
                }
                else{
                    i++;
                    j++;
                }
                if(change>1) return false;
            }
            if(i==s.length()-1) return true;
            return change==1;
        }

    }
}
