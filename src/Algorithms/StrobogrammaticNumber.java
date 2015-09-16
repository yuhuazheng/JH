package Algorithms;

import java.util.HashMap;

/**
 * Created by yuhuazh on 9/13/2015.
 */
public class StrobogrammaticNumber {
    public boolean isStrobogrammatic(String num) {
        if(num==null||num.length()==0) return true;
        HashMap<Character,Character> map = new HashMap<Character,Character>();
        map.put('1','1');
        map.put('8','8');
        map.put('6','9');
        map.put('9','6');
        map.put('0','0');

        int l=0;
        int r=num.length()-1;
        while(l<r){
            char c1=num.charAt(l++);
            char c2=num.charAt(r--);
            if( (!map.containsKey(c1) && !map.containsKey(c2)) || c2!=map.get(c1))
                return false;
        }
        if(l==r && num.charAt(l)!='1' && num.charAt(l)!='8' && num.charAt(l)!='0')
            return false;
        return true;
    }
}
