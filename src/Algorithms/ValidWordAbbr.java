package Algorithms;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by yuhuazh on 2/28/2016.
 */
public class ValidWordAbbr {
    //<code,<strings>>
    HashMap<String,HashSet<String>> map = new HashMap<String,HashSet<String>>();

    public ValidWordAbbr(String[] dictionary) {
        for(String s : dictionary){
            String c = enCode(s);
            if(!map.containsKey(c)){
                HashSet<String> ss = new HashSet<>();
                ss.add(s);
                map.put(c,ss);
            }
            else{
                if(!map.get(c).contains(s)){
                    map.get(c).add(s);
                }
            }
        }
    }

    public boolean isUnique(String word) {
        String c = enCode(word);
        if(!map.containsKey(c)
                ||(map.containsKey(c) && map.get(c).size()==1 && map.get(c).contains(word)) ) return true;
        return false;
    }

    private String enCode(String s){
        if(s.length()<3) return s;
        return s.substring(0,1)+Integer.toString(s.length()-2)+s.substring(s.length()-1);
    }
}
