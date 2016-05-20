import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuhua on 20/05/16.
 */
public class StrobogrammaticNumberIII {
    public static void main(String[] args){
        StrobogrammaticNumberIII inst = new StrobogrammaticNumberIII();
        int res = inst.strobogrammaticInRange("0","100000000000000");
        System.out.println(res);
    }

    public int strobogrammaticInRange(String low, String high) {
        int m = low.length();
        int n = high.length();
        int count=0;
        for(int l=m;l<=n;l++){
            List<String> nums = findStrobogrammatic(l,low,high);
            count+=nums.size();
        }
        return count;
    }

    public List<String> findStrobogrammatic(int n, String low, String high) {
        List<String> res = new ArrayList<>();
        if(n<=0) return res;

        if(n%2==0) helper(n, new StringBuilder(), res);
        else{
            helper(n, new StringBuilder("0"), res);
            helper(n,new StringBuilder("1"),res);
            helper(n,new StringBuilder("8"),res);
        }
        if(n==low.length())
            removeNumber(res,low,false);
        if(n==high.length())
            removeNumber(res,high,true);
        return res;
    }

    private void helper(int n, StringBuilder sb,List<String> res){
        if(sb.length()==n){
            res.add(sb.toString());
            return;
        }

        char[] left = {'0','1','8','6','9'};
        char[] right = {'0','1','8','9','6'};
        int curlen = sb.length();
        for(int i=0;i<left.length;i++){
            if(curlen==n-2 && i==0) continue; //0 can't be at the first or last digit
            sb.insert(0, left[i]);
            sb.append(right[i]);
            helper(n, sb, res);
            sb.deleteCharAt(0);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    private void removeNumber(List<String> strs, String threshold, boolean lowOrHigh){
        int n = threshold.length();
        int i=0;
        while(i<strs.size()){
            boolean toDel=false;
            String s = strs.get(i);
            for(int j=0;j<n;j++){
                if(lowOrHigh){//strs should be lower than threshold
                    if(s.charAt(j)<threshold.charAt(j)){ //if a high char is lower, no need to go further
                        break;
                    }
                    if(s.charAt(j)>threshold.charAt(j)){
                        toDel=true;
                        break;
                    }
                }
                else { //should be bigger than threshold
                    if (s.charAt(j) > threshold.charAt(j))
                        break;
                    if (s.charAt(j) < threshold.charAt(j)) {
                        toDel = true;
                        break;
                    }
                }
            }
            if(toDel)
                strs.remove(i);
            else
                i++;
        }
    }
}
