package Algorithms;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by yuhuazh on 4/10/2016.
 */
public class BasicCalculator {
    public int calculate(String s) {
        //format numbers and operators
        ArrayList<String> stk = new ArrayList<>();
        int i=0;
        int start=0;
        while(i<=s.length()) {
            if (i<s.length()
                    && ((s.charAt(i) >= '0' && s.charAt(i) <= '9')||s.charAt(i)==' ')
                    ){
                i++;
            } else {
                String sub = s.substring(start, i);
                sub=sub.trim();
                stk.add(sub);
                if(i<s.length()) stk.add(String.valueOf(s.charAt(i)));
                i++;
                start = i;
            }
        }

        //compute * and /
        ArrayList<String> stk2 = new ArrayList<>();
        i=0;
        while(i<stk.size()){
            String cur = stk.get(i);
            if(cur.equals("*")||cur.equals("/")){
                int n1 = Integer.valueOf(stk2.get(stk2.size()-1));
                int n2 = Integer.valueOf(stk.get(++i));
                int n3 = n1*n2;
                if(cur.equals("/")) n3 = n1/n2;
                stk2.remove(stk2.size()-1);
                stk2.add(String.valueOf(n3));
            }
            else{
                stk2.add(cur);
            }
            i++;
        }

        //compute res
        int res=Integer.valueOf(stk2.get(0));
        i=1;
        while(i<stk2.size()){
            String cur = stk2.get(i);
            if(cur.equals("+")) res+=Integer.valueOf(stk2.get(++i));
            if(cur.equals("-")) res-=Integer.valueOf(stk2.get(++i));
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        BasicCalculator inst = new BasicCalculator();
        String s ="100000000/1/2/3/4/5/6/7/8/9/10";
        System.out.println(inst.calculate(s));
    }
}
