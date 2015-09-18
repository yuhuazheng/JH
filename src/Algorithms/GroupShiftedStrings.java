package Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by yuhua on 9/16/15.
 */
public class GroupShiftedStrings {

    public static void main(String[] args){
        String[] strings = {"aa","bb","ccc"};
        GroupShiftedStrings inst = new GroupShiftedStrings();
        List<List<String>> res = inst.groupStrings(strings);
        for(int i=0; i<res.size();i++){
            System.out.println(res.get(i));
        }
    }

    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(strings==null||strings.length==0) return res;
        Arrays.sort(strings);

        boolean[] grouped = new boolean[strings.length];
        for(int i=0;i<strings.length;i++){
            if(grouped[i]) {
                continue;
            }
            //start a group
            String base = strings[i];
            int len = base.length();
            List<String> curGroup = new ArrayList<String>();
            curGroup.add(base);
            grouped[i]=true;

            //extend group
            for(int j=i+1;j<strings.length;j++){
                String cur = strings[j];
                if(cur.length()!=len){
                    continue;
                }

                int shift = cur.charAt(0)-base.charAt(0);
                boolean sameGroup = true;
                for(int k=1;k<len;k++){
                    int diff = cur.charAt(k)-base.charAt(k);
                    if(shift*diff<0) diff+=26;
                    if(diff!=shift){
                        sameGroup=false;
                        break;
                    }
                }
                if(sameGroup){
                    curGroup.add(cur);
                    grouped[j]=true;
                }
            }

            //add to list
            res.add(curGroup);
        }
        return res;
    }
}
