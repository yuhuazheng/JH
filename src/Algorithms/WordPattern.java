package Algorithms;

import java.util.HashMap;

/**
 * Created by yuhuazh on 10/5/2015.
 */
public class WordPattern {

    public static void main(String[] args){
        String pattern = "abba";
        String str = "dog cat cat dog";
        WordPattern inst = new WordPattern();
        System.out.println(inst.wordPattern(pattern,str));
    }

    public boolean wordPattern(String pattern, String str) {
        if(pattern==null&&str==null) return true;
        if(pattern==null||str==null) return false;
        if(pattern.length()==0&&str.length()==0) return true;
        if(pattern.length()==0||str.length()==0) return false;

        String[] strs = str.split("[ ]");
        if(pattern.length()!=strs.length) return false;

        HashMap<Character,String> p2s = new HashMap<Character,String>();
        HashMap<String,Character> s2p = new HashMap<String,Character>();
        for(int i=0;i<strs.length;i++){
            char c = pattern.charAt(i);
            String s = strs[i];
            if(!p2s.containsKey(c) && !s2p.containsKey(s)){
                p2s.put(c,s);
                s2p.put(s,c);
            }
            else if( (p2s.containsKey(c)&&p2s.get(c).equals(s))
                    && (s2p.containsKey(s)&&s2p.get(s)==c)
                    ){
                continue;
            }
            else{
                return false;
            }
        }
        return true;
    }
}
