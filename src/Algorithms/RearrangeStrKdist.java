import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.util.*;

/**
 * Created by yuhua on 14/06/16.
 */
public class RearrangeStrKdist {
    public String rearrangeString(String str, int k) {
        if(str==null||str.length()==0) return "";
        HashMap<Character,Integer> countMap = new HashMap<>();
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(!countMap.containsKey(c))
                countMap.put(c,1);
            else
                countMap.put(c,countMap.get(c)+1);
        }

        PriorityQueue<Map.Entry<Character,Integer>> q = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue()-o1.getValue(); //more count stay at front
            }
        });
        for(Map.Entry<Character,Integer> kv : countMap.entrySet()){
            q.offer(kv);
        }
        List<Map.Entry<Character,Integer>> buf = new ArrayList<>();
        HashMap<Character,Integer> positionMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        Map.Entry<Character,Integer> head = q.poll();
        sb.append(head.getKey());
        head.setValue(head.getValue()-1);
        if(head.getValue()>0)
            q.offer(head);
        positionMap.put(head.getKey(),0);

        while(!q.isEmpty()){
            Map.Entry<Character,Integer> top=q.poll();
            char cur = top.getKey();
            int idx = sb.length();
            if(positionMap.containsKey(cur) && (idx-positionMap.get(cur))<k){
                buf.add(top);
                continue;
            }
            sb.append(cur);
            top.setValue(top.getValue()-1);
            if(top.getValue()>0)
                q.offer(top);
            positionMap.put(cur,idx);
            while(!buf.isEmpty())
                q.offer(buf.remove(0));
        }

        if(!buf.isEmpty()) return "";
        return sb.toString();
    }

    public static void main(String[] args) {
        RearrangeStrKdist inst = new RearrangeStrKdist();
        String str = "aabbcc";
        System.out.println(inst.rearrangeString(str,3));
    }
}
