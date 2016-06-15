import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by yuhuazh on 6/14/2016.
 */
public class RemoveDupLetters {
    public String removeDuplicateLetters(String s) {
        if(s==null||s.length()==0) return "";
        int[] counts = new int[26];
        for(int i=0;i<s.length();i++){
            counts[s.charAt(i)-'a']++;
        }
        boolean[] contained = new boolean[26];
        Stack<Character> res = new Stack<>();
        res.push(s.charAt(0));
        counts[s.charAt(0)-'a']--;
        contained[s.charAt(0)-'a']=true;

        for(int i=1;i<s.length();i++){
            char c = s.charAt(i);
            counts[c-'a']--;
            if(contained[c-'a']) continue;
            while(!res.isEmpty()&&res.peek()>c&&counts[res.peek()-'a']>0){ //pop top element and there is more later
                    int p = res.pop();
                    contained[p-'a']=false;
            }
            res.push(c);
            contained[c-'a']=true;
        }
        StringBuilder sb = new StringBuilder();
        while(!res.isEmpty()){
            sb.append(res.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        RemoveDupLetters inst = new RemoveDupLetters();
        System.out.println(inst.removeDuplicateLetters("bbcaac"));
    }
}
