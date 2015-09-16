package Algorithms;

import java.util.HashMap;

/**
 * Created by yuhuazh on 9/13/2015.
 */
public class PalindromePermutation {

    public boolean canPermutePalindrome(String s) {
        if(s==null||s.length()==0) return true;

        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        char[] chs = s.toCharArray();
        int oddCount=0;
        for(int i=0;i<chs.length;i++){
            char c = chs[i];
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
                if(map.get(c)%2==0){
                    oddCount--;
                }
                else{
                    oddCount++;
                }
            }
            else{
                map.put(c,1);
                oddCount++;
            }
        }
        return oddCount<=1;
    }
}
