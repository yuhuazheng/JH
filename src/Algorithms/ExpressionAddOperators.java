import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuhuazh on 6/14/2016.
 */
public class ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if((num==""||num.length()==0)&&target==0) return res;
        dfs(num, target, 0, 0, "", res);
        return res;
    }
    public void dfs(String num, int target, long cur, long diff, String temp, List<String> res) {
        if(cur == target && num.length() == 0) {
            res.add(temp);
        }
        for(int i = 1; i<=num.length(); i++) {
            String str = num.substring(0, i);
            if(str.length()>1 && '0' == str.charAt(0)) return;
            String next = num.substring(i);
            if(temp.length() >0) {
                dfs(next, target, Long.parseLong(str) + cur, Long.parseLong(str), temp + "+" +str, res);
                dfs(next, target, cur - Long.parseLong(str), -Long.parseLong(str), temp + "-" +str, res);
                dfs(next, target, (cur - diff) + diff * Long.parseLong(str), Long.parseLong(str)*diff, temp + "*" +str, res);
            } else {
                dfs(next, target, Long.parseLong(str), Long.parseLong(str), str, res);
            }
        }
    }
}
