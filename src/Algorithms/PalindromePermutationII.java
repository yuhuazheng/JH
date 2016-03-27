package Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yuhua on 3/25/16.
 */
public class PalindromePermutationII {
    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<>();
        if(s==null||s.length()==0) return res;

        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        StringBuilder sb = new StringBuilder();
        StringBuilder cur = new StringBuilder();
        char oddChar=chars[0];
        boolean isOdd=false;
        int count=1;
        for(int i=1;i<=chars.length;i++){
            if(i<chars.length && chars[i]==chars[i-1]){
                count++;
            }
            else{
                if(count%2==1){
                    if(isOdd) return res; //more than one odd
                    isOdd=true;
                    oddChar=chars[i-1];
                }
                char[] chs = new char[count/2];
                Arrays.fill(chs,chars[i-1]);
                cur.append(chs);
                sb.append(cur.toString());
                cur = new StringBuilder();
                if(i<chars.length) {
                    count = 1;
                }
            }
        }

        //permute first half
        chars = sb.toString().toCharArray();
        boolean[] used = new boolean[chars.length];
        permute(chars,used,new StringBuilder(),res);

        //complete res
        for(int i=0;i<res.size();i++){
            String str = res.get(i);
            res.remove(i);
            String mirror = new StringBuilder(str).reverse().toString();
            cur = new StringBuilder(str);
            if(isOdd) cur.append(oddChar);
            cur.append(mirror);
            res.add(i, cur.toString());
        }
        return res;
    }

    private void permute(char[] chars, boolean[] used, StringBuilder sb, List<String> res){
        if(sb.length()==chars.length){
            res.add(sb.toString());
            return;
        }
        for(int i=0;i<chars.length;i++){
            if(used[i]) continue;
            if(i>0&&!used[i-1]&&chars[i]==chars[i-1]) continue;
            used[i]=true;
            sb.append(chars[i]);
            permute(chars, used, sb, res);
            sb.deleteCharAt(sb.length() - 1);
            used[i]=false;
        }
        return;
    }

    public static void main(String[] args) {
        PalindromePermutationII inst = new PalindromePermutationII();
        String s = "aabb";
        List<String> res = inst.generatePalindromes(s);
        for(String str: res){
            System.out.println(str);
        }
    }
}
