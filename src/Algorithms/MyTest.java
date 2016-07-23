import java.util.HashMap;

/**
 * Created by yuhuazh on 7/14/2016.
 */
public class MyTest {

    public int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()==0) return 0;
        HashMap<Character,Integer> map = new HashMap<>();
        map.put(s.charAt(0),0);
        int maxLen=1;
        int l=0;
        for(int i=1;i<s.length();i++){
            char c = s.charAt(i);
            if(!map.containsKey(c)){
                map.put(c,i);
                maxLen=Math.max(maxLen,i-l+1);
            }
            else{
                char pre=s.charAt(l);
                while(pre!=c){
                    map.remove(pre);
                    l++;
                    pre=s.charAt(l);
                }
                l++;
                maxLen=Math.max(maxLen,i-l+1);
                map.put(c,i);
            }
        }
        maxLen=Math.max(maxLen,s.length()-l);
        return maxLen;
    }

    public static void main(String[] args) {
        MyTest inst = new MyTest();
        String s = "tmmzuxt";
        System.out.println(inst.lengthOfLongestSubstring(s));
    }
}
