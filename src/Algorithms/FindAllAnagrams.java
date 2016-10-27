import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by yuhua on 26/10/16.
 */
public class FindAllAnagrams {
    public List<Integer> findAnagrams(String s, String p) {

        /* much shorter code
        List<Integer> list = new ArrayList<>();
    if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;
    int[] hash = new int[256]; //character hash
    //record each character in p to hash
    for (char c : p.toCharArray()) {
        hash[c]++;
    }
    //two points, initialize count to p's length
    int left = 0, right = 0, count = p.length();
    while (right < s.length()) {
        //move right everytime, if the character exists in p's hash, decrease the count
        //current hash value >= 1 means the character is existing in p
        if (hash[s.charAt(right++)]-- >= 1) count--;

        //when the count is down to 0, means we found the right anagram
        //then add window's left to result list
        if (count == 0) list.add(left);

        //if we find the window's size equals to p, then we have to move left (narrow the window) to find the new match window
        //++ to reset the hash because we kicked out the left
        //only increase the count if the character is in p
        //the count >= 0 indicate it was original in the hash, cuz it won't go below 0
        if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0) count++;
    }
    return list;
         */


        List<Integer> res = new ArrayList<>();
        if((s==null||s.length()==0) || (p==null||p.length()==0) )
            return res;

        //a simpler way is to use only 26 lower case char, construct map as an array.
        HashMap<Character, Integer> buf = getMap(p);
        int count=p.length();
        int left=0;
        int cur=0;
        int matched=0;

        while(cur<s.length()){
            char c = s.charAt(cur);
            if(!buf.containsKey(c)){
                if(matched!=0){
                    buf=getMap(p);
                    matched=0;
                }
            }
            else{
                if(buf.get(c)>0){
                    buf.put(c,buf.get(c)-1);
                    matched++;
                    if(matched==1){
                        left=cur;
                    }
                    if(matched==count){
                        res.add(left);
                        char firstCh = s.charAt(left);
                        buf.put(firstCh,buf.get(firstCh)+1);
                        left++;
                        matched--;
                    }
                }
                else{
                    char firstCh = s.charAt(left);
                    while(firstCh!=c&&left<cur){
                        buf.put(firstCh,buf.get(firstCh)+1);
                        left++;
                        matched--;
                        firstCh = s.charAt(left);
                    }
                    if(left<cur){
                        left++;
                    }
                }
            }
            cur++;
        }
        return res;
    }

    private HashMap<Character,Integer> getMap(String p){
        HashMap<Character, Integer> mp = new HashMap<>();
        for(char c: p.toCharArray()){
            if(!mp.containsKey(c))
                mp.put(c,1);
            else
                mp.put(c,mp.get(c)+1);
        }
        return mp;
    }

    public static void main(String[] args) {
        FindAllAnagrams inst = new FindAllAnagrams();
        String s ="abab";
        String p ="ab";
        List<Integer> res = inst.findAnagrams(s,p);
        for(int i : res){
            System.out.print(i);
            System.out.print(", ");
        }
    }
}
