package Algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuhua on 1/2/16.
 */
public class GeneralizedAbbreviations {
    public static void main(String[] args) {
        String w = "word";
        GeneralizedAbbreviations inst = new GeneralizedAbbreviations();
        List<String> res = inst.generateAbbreviations(w);
        for(String str : res){
            System.out.print(str);
            System.out.print(" , ");
        }
    }

    public List<String> generateAbbreviations(String word) {
        List<String> pre = new ArrayList<>();
        pre.add("");
        if(word==null || word.length()==0) return pre;

        for(int i=0;i<word.length();i++){
            List<String> cur = new ArrayList<>();
            String[] toAdd = {word.substring(i,i+1),"1"};
            StringBuilder sb = new StringBuilder();
            for(String add: toAdd){
                for(String item : pre) {
                    sb.setLength(0);
                    sb.append(item);
                    sb.append(add);
                    cur.add(sb.toString());
                }
            }
            pre=cur;
        }
        //merge numbers
        List<String> res = new ArrayList<>();
        for(String item : pre){
            StringBuilder sb = new StringBuilder();
            int count=0;
            for(int i=0;i<item.length();i++){
                if(item.charAt(i)=='1'){
                    count++;
                    if(i==item.length()-1)
                        sb.append(count);
                }
                else{
                    if(count>0){
                        sb.append(count);
                        count=0;
                    }
                    sb.append(item.charAt(i));
                }
            }
            res.add(sb.toString());
        }
        return res;
    }
}
