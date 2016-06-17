import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created by yuhuazh on 6/16/2016.
 */
public class AlienDictionary {
    public String alienOrder(String[] words) {
        if(words==null||words.length==0) return "";

        //for topological sort, DFS needs 1) current node and its children/neighbors, 2)"used" data structure,
        //3) "item/path" for ongoing branch, (2 and 3 can be combined into same data structure) 4) global results if needed

        //to hold node and its children
        HashMap<Character,HashSet<Character>> graph = new HashMap<>();
        for(int i=1;i<words.length;i++){
            String pre = words[i-1];
            String cur = words[i];
            for(int j=0;j<Math.min(pre.length(),cur.length());j++){
                char c1=pre.charAt(j);
                char c2=cur.charAt(j);
                if(c1==c2){
                    continue;
                }
                else{//c2 is a child of c1
                    if(!graph.containsKey(c1))
                        graph.put(c1,new HashSet<>());
                    graph.get(c1).add(c2);
                    break;
                }
            }
        }

        //'used'
        HashMap<Character,Integer> used = new HashMap<>();//0:new, 1: using, 2: used
        for(int i=0;i<words.length;i++){
            String s = words[i];
            for(char c : s.toCharArray()){
                if(!used.containsKey(c))
                    used.put(c,0);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(char c : graph.keySet()){
            if(used.get(c)==2) //checked already
                continue;
            if(!DFS(c,graph,used,sb))
                return "";
        }

        //possible that not all char have orders, some might be isolated
        for(char c: used.keySet()){
            if(used.get(c)==0){
                used.put(c,2);
                sb.insert(0,c); //insert at front since it has no order
            }
        }

        return sb.toString();
    }

    //true if no cycle;
    private boolean DFS(char c, HashMap<Character,HashSet<Character>> graph, HashMap<Character,Integer> used, StringBuilder sb){
        used.put(c,1); //during checking
        if(!graph.containsKey(c)){ //isolated
            used.put(c,2);
            sb.insert(0,c);
            return true;
        }
        for(char n : graph.get(c)){
            if(used.get(n)==1)
                return false;
            if(used.get(n)==0 && !DFS(n,graph,used,sb))
                return false;
        }
        used.put(c,2);
        sb.insert(0,c); //DFS, so lower order will be inserted already
        return true;
    }

    public static void main(String[] args) {
        AlienDictionary inst  = new AlienDictionary();
        String[] words = {"a","b","ca","cc"};
        System.out.println(inst.alienOrder(words));
    }
}
