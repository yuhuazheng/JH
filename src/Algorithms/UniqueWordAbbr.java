package Algorithms;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by yuhuazh on 10/1/2015.
 */
public class UniqueWordAbbr {
    HashMap<String,Integer> map;
    HashSet<String> dic;

    public UniqueWordAbbr(String[] dictionary) {
        map= new HashMap<String,Integer>();
        dic= new HashSet<String>();
        for(String str : dictionary){
            dic.add(str);
            String code = getAbbr(str);
            if(code!=null && code.length()>0){
                if(map.containsKey(code)){
                    map.put(code,map.get(code)+1);
                }
                else{
                    map.put(code,1);
                }
            }
        }
    }

    public boolean isUnique(String word) {
        String code = getAbbr(word);
        if( (!dic.contains(word) && !map.containsKey(code))
            || (dic.contains(word) && map.containsKey(code) && map.get(code)==1)
                )
            return true;
        return false;
    }

    private String getAbbr(String word){
        if(word==null||word.length()<1) return "";
        StringBuilder code = new StringBuilder();
        code.append(word.charAt(0));
        int count=0;
        for(int i=1;i<word.length()-1;i++){
            count++;
        }
        code.append(count);
        code.append(word.charAt(word.length()-1));
        return code.toString();
    }

    public static void main(String[] args){
        String[] dict = {"dog"};
        UniqueWordAbbr inst = new UniqueWordAbbr(dict);
        System.out.println(inst.isUnique("dig"));
        System.out.println(inst.isUnique("dug"));
        System.out.println(inst.isUnique("dag"));
        System.out.println(inst.isUnique("dog"));
        System.out.println(inst.isUnique("doge"));
    }
}
