package Algorithms;

import java.util.*;

/**
 * Created by yuhua on 3/26/16.
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> results = new ArrayList<List<String>>();
        List<String> ept = new ArrayList<String>();
        if(strs==null || strs.length==0){
            results.add(ept);
            return results;
        }

        HashMap<String, ArrayList<String>> map = new HashMap<String,ArrayList<String>>();

        for(String str1: strs){
            char[] charray = str1.toCharArray();
            Arrays.sort(charray);
            String str2 = new String(charray);
            if(map.containsKey(str2)){
                ArrayList<String> value = map.get(str2);
                value.add(str1);
                map.put(str2, value);
            }
            else{
                ArrayList<String> value = new ArrayList<String>();
                value.add(str1);
                map.put(str2, value);
            }
        }

        for(String str3 : map.keySet()){
            ArrayList<String> value = map.get(str3);
            if(value.size()>0){
                Collections.sort(value);
                results.add(value);
            }
        }
        return results;
    }

    public static void main(String[] args) {
        GroupAnagrams inst = new GroupAnagrams();
        String[] strs = {""};
        List<List<String>> res = inst.groupAnagrams(strs);
        for(List<String> l: res){
            System.out.println(l.toArray());
        }
    }
}
