package Algorithms;

import java.util.*;

/**
 * Created by yuhua on 9/16/15.
 */
public class GroupShiftedStrings {

    public static void main(String[] args){
        String[] strings = {"abc","am"};
        GroupShiftedStrings inst = new GroupShiftedStrings();
        List<List<String>> res = inst.groupStrings(strings);
        for(int i=0; i<res.size();i++){
            System.out.println(res.get(i));
        }
    }

    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(strings==null||strings.length==0) return res;

        HashMap<String, List<String>> map = new HashMap<>();
        for(int i=0;i<strings.length;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<strings[i].length();j++){
                //compute shiftcode
                sb.append((strings[i].charAt(j)-strings[i].charAt(0)+26)%26);
                sb.append("-"); //this separator is important, since the diff could be bigger than 10 which equals to two position diffs.
            }
            String shiftcode = sb.toString();
            if(map.containsKey(shiftcode)){
                map.get(shiftcode).add(strings[i]);
            }
            else{
                List<String> l = new ArrayList<String>();
                l.add(strings[i]);
                map.put(shiftcode,l);
            }
        }

        for(String s : map.keySet()){
            Collections.sort(map.get(s));
            res.add(map.get(s));
        }
        return res;
    }
}
