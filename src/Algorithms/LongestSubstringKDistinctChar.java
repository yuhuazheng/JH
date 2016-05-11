package Algorithms;

import java.util.HashMap;

/**
 * Created by yuhuazh on 5/11/2016.
 */
public class LongestSubstringKDistinctChar {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s==null||s.length()==0 || k==0) return 0;
        HashMap<Character,Integer> buff  = new HashMap<>();
        int l=0;
        int curMax=1;
        buff.put(s.charAt(0),0);
        for(int i=1;i<s.length();i++){
            char c = s.charAt(i);
            if(!buff.containsKey(c)&& buff.size()==k){
                int temp = i-l;
                curMax = Math.max(curMax,temp);

                while(l<i){
                    if(l==buff.get(s.charAt(l))) {//reach to last unique char
                        buff.remove(s.charAt(l));
                        break;
                    }
                    l++;
                }
                l++;//reset l
            }
            buff.put(c,i);
        }
        int temp = s.length()-l;
        curMax = Math.max(curMax,temp);
        return curMax;
    }

    public static void main(String[] args) {
        String s = "eceba";
        int k=2;
        LongestSubstringKDistinctChar inst = new LongestSubstringKDistinctChar();
        System.out.println(inst.lengthOfLongestSubstringKDistinct(s,k));
    }
}
