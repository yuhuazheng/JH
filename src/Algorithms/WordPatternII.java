package Algorithms;

import java.util.HashMap;

/**
 * Created by yuhua on 5/13/16.
 */
public class WordPatternII {
    public boolean wordPatternMatch(String pattern, String str) {
        if((pattern==null||pattern.length()==0) && (str==null||str.length()==0)) return true;
        if((pattern==null||pattern.length()==0) || (str==null||str.length()==0)) return false;

        HashMap<Character,String> p2wMap = new HashMap<>();
        return helper(0, 0, pattern, str, p2wMap);
    }

    private boolean helper(int patnIdx, int strIdx, String pattern, String str, HashMap<Character,String> p2wMap){
        if(patnIdx==pattern.length() && strIdx==str.length()){
            //all pattern is matched, str is fully used
            return true;
        }
        else if(patnIdx==pattern.length() || strIdx==str.length()){
            //all pattern is matched or str is fully used, only one is true
            return false;
        }


        char nextP = pattern.charAt(patnIdx);
        if(p2wMap.containsKey(nextP)){
            String nextW=p2wMap.get(nextP);
            if(strIdx+nextW.length()<=str.length() && str.substring(strIdx,strIdx+nextW.length()).equals(nextW)){
                patnIdx++;
                return helper(patnIdx, strIdx+nextW.length(),pattern,str,p2wMap);
            }
            return false;
        }
        else{
            //new mapping
            for(int i=strIdx+1;i<=str.length();i++){
                String nextCand = str.substring(strIdx,i);
                if(p2wMap.values().contains(nextCand)){
                    //word already used, move on
                    continue;
                }
                //try a new mapping
                p2wMap.put(nextP, nextCand);
                patnIdx++;
                if(helper(patnIdx,i,pattern,str,p2wMap)){
                    return true;
                }
                //invalid mapping, backtracking
                patnIdx--;
                p2wMap.remove(nextP);
            }
            return false;
        }
    }

    public static void main(String[] args) {
        String pattern = "itwasthebestoftimes";
        String str = "ittwaastthhebesttoofttimesss";
        WordPatternII inst = new WordPatternII();
        System.out.println(inst.wordPatternMatch(pattern,str));
    }
}
