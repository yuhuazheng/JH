import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by yuhuazh on 6/19/2016.
 */
public class PalindromePairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        if (words == null || words.length == 0) {
            List<Integer> empty = new ArrayList<>();
            res.add(empty);
            return res;
        }

        HashMap<String, Integer> mp = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            mp.put(words[i], i);
        }

        List<Integer> temp;
        for (String w1 : mp.keySet()) {
            if (w1.equals(""))
                continue;

            //itself is palindrome
            if (isPalindrome(w1) && mp.containsKey("")) {
                int i1=mp.get("");
                int i2=mp.get(w1);
                addRes(i1,i2,res);
                addRes(i2,i1,res);
            }

            //itself and its mirror is palindrome
            StringBuilder sb = new StringBuilder(w1);
            String mirror = sb.reverse().toString();
            if (mp.containsKey(mirror)&& mp.get(mirror)!=mp.get(w1)) {
                addRes(mp.get(w1),mp.get(mirror),res);
            }

            //part of it and another word is palindrome
            for (int i = 1; i < w1.length(); i++) {
                String left = w1.substring(0, i);
                String right = w1.substring(i);
                sb = new StringBuilder(left);
                String mirrorL = sb.reverse().toString();
                sb = new StringBuilder(right);
                String mirrorR = sb.reverse().toString();
                if (isPalindrome(left) && mp.containsKey(mirrorR)) {
                    addRes(mp.get(mirrorR),mp.get(w1),res);
                }
                if (isPalindrome(right) && mp.containsKey(mirrorL)) {
                    addRes(mp.get(w1),mp.get(mirrorL),res);
                }
            }
        }
        return res;
    }

        private boolean isPalindrome(String s) {
            if (s == null || s.length() == 0) return true;
            int l = 0;
            int r = s.length() - 1;
            while (l <=r) {
                if (s.charAt(l) != s.charAt(r))
                    return false;
                l++;
                r--;
            }
            return true;
        }

        private void addRes(int i1, int i2, List<List<Integer>> res){
            List<Integer> temp = new ArrayList<>();
            temp.add(i1);
            temp.add(i2);
            res.add(temp);
        }

    public static void main(String[] args) {
        String[] words = {"abcd","dcba","lls","s","sssll"};
        PalindromePairs inst = new PalindromePairs();
        List<List<Integer>> res = inst.palindromePairs(words);
        System.out.println(res.size());
    }

}
