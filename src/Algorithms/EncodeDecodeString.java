package Algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuhuazh on 10/14/2015.
 */
public class EncodeDecodeString {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String cur : strs){
            sb.append(cur.length());
            sb.append("#");
            sb.append(cur);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<String>();
        int i=0;
        while(i<s.length()){
            int cutoff = s.indexOf("#",i);
            int len = Integer.parseInt(s.substring(i,cutoff));
            res.add(s.substring(cutoff+1,cutoff+1+len));
            i=cutoff+len+1;
        }
        return res;
    }

    public static void main(String[] args){
        EncodeDecodeString inst = new EncodeDecodeString();
        List<String> strs = new ArrayList<>();
        strs.add("first string");
        strs.add("second string");
        String code = inst.encode(strs);
        List<String> de = inst.decode(code);
        System.out.print(de);
    }
}
