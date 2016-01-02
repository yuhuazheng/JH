package Algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by yuhua on 12/27/15.
 */
public class GroupShiftedStrings2 {
    public static void main(String[] args){
        String[] strings = {"az","yx"};
        GroupShiftedStrings2 inst = new GroupShiftedStrings2();
        List<List<String>> res = inst.groupStrings(strings);
        for(int i=0; i<res.size();i++){
            System.out.println(res.get(i));
        }
    }

    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(strings==null||strings.length==0) return res;
        HashMap<String,List<String>> map = new HashMap<String,List<String>>();
        for(int i=0;i<strings.length;i++){
            StringBuilder sb = new StringBuilder();
            String str = strings[i];
            for(int j=1;j<str.length();j++){
                int offset = (str.charAt(j)-str.charAt(0)+26)%26;
                sb.append(offset);
                sb.append("#");
            }
            String code = sb.toString();
            if(map.containsKey(code)){
                map.get(code).add(str);
            }
            else{
                List<String> temp = new ArrayList<String>();
                temp.add(str);
                map.put(code,temp);
            }
        }

        for(String str : map.keySet()){
            res.add(map.get(str));
        }

        return res;
    }
}
