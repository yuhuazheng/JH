package Algorithms;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by yuhuazh on 7/2/2016.
 */
public class LongestChain {
    public static int lc(String[] words) {
        HashSet<String> dict = new HashSet<String>();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        //use map to store the longest len for string, save time
        for (String s : words) {
            dict.add(s);
        }
        int longest = 0;
        for (String s : words) {
            if (s.length() <= longest) {
                continue;//no need to process s, since its longest length can be at most longest
            }
            int len = helper(s, dict, map) + 1;//s itself is already in the dict, so + 1
            map.put(s, len);
            longest = Math.max(len, longest);
        }
        return longest;
    }

    public static int helper(String s, HashSet<String> dict, HashMap<String, Integer> map) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            String newStr = s.substring(0, i) + s.substring(i + 1);
            //create a new string by removing a char
            if (dict.contains(newStr)) {
                if (map.containsKey(newStr)) {
                    result = Math.max(result, map.get(newStr));
                } else {
                    result = Math.max(result, helper(newStr, dict, map) + 1);
                }

            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] words = {"a", "abcd", "bcd", "abd", "cd", "c"};
        System.out.print(lc(words));
    }
}