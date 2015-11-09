package Algorithms;

import java.util.HashMap;
import java.util.Objects;

public class IsomorphicStrings {

    public static void main(String[] args) {
        String s = "abb";
        String t = "acd";
        IsomorphicStrings inst = new IsomorphicStrings();
        System.out.println(inst.isIsomorphic(s, t));
    }

    public boolean isIsomorphic(String s, String t) {
        if ((s == null && t == null) || (s.length() < 1 && t.length() < 1)) return true;
        HashMap<Character, Character> map1 = new HashMap<Character, Character>();

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (map1.containsKey(c1)) {
                if (c2 != map1.get(c1)) return false;
            } else if (map1.containsValue(c2)) {
                return false;
            } else {
                map1.put(c1, c2);
            }
        }
        return true;
    }
}
