import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuhuazh on 9/8/2016.
 */
public class StringCombination {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        List<Integer> values = new ArrayList<>();
        words.add("apple");
        words.add("banana");
        words.add("peach");
        words.add("cherry");
        values.add(2);
        values.add(3);
        values.add(6);
        values.add(7);
        int target =7;

        StringCombination inst = new StringCombination();
        List<List<String>> res = new ArrayList<>();
        res = inst.findSum(words,values,target);
        for(List<String> l: res){
            System.out.println(l);
        }
    }

    public List<List<String>> findSum(List<String> words, List<Integer> values, int target){
        List<List<String>> res = new ArrayList<>();
        if(words==null||words.size()==0||values==null||values.size()==0) return res;
        DFS(words,values,target,0,new ArrayList<String>(),res);
        return res;
    }

    private void DFS(List<String> words,List<Integer> values,int target,int start, List<String> item, List<List<String>> res){
        if(start>=words.size()) return;
        if(target==0&&item.size()>0){
            res.add(new ArrayList<String>(item));
            return;
        }

        for(int j=start;j<words.size();j++){
            if(values.get(j)>target)
                continue;
            item.add(words.get(j));
            DFS(words,values,target-values.get(j),j,item,res);
            item.remove(item.size()-1);
        }
    }
}
