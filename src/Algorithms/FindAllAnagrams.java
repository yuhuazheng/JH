import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by yuhua on 26/10/16.
 */
public class FindAllAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
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
