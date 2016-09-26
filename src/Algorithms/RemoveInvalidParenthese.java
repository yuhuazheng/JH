

import java.util.*;


/**
 * Created by yuhua on 5/15/16.
 */
public class RemoveInvalidParenthese {
    public List<String> removeInvalidParentheses(String s) {
        HashSet<String> res = new HashSet<>();
        if(s==null||s.length()==0)
            res.add("");
        else
            helper(0,0,0,s,new StringBuilder(),res);
        List<String> r = new ArrayList<>(res);
        return r;
    }

    private void helper(int idx, int lCount, int rCount, String s, StringBuilder sb, HashSet<String> res){
        if(rCount>lCount) return;
        if(idx==s.length()){
            if(lCount!=rCount) return;

            if(res.isEmpty())
                res.add(new String(sb.toString()));
            else{
                Iterator it = res.iterator();
                int len = ((String)it.next()).length();
                if(sb.length()<len)
                    return;
                else if(sb.length()==len) {
                    res.add(new String(sb.toString()));
                }
                else{
                    res.clear();
                    res.add(new String(sb.toString()));
                }
            }
            return;
        }

        char c = s.charAt(idx);
        if(c=='('){
            sb.append('(');
            helper(idx+1,lCount+1,rCount,s,sb,res);
            sb.deleteCharAt(sb.length()-1);
            helper(idx+1,lCount,rCount,s,sb,res);//remove current (
        }
        else if(c==')'){
            sb.append(')');
            helper(idx+1,lCount,rCount+1,s,sb,res);
            sb.deleteCharAt(sb.length()-1);
            helper(idx+1,lCount,rCount,s,sb,res);
        }
        else{
            sb.append(c);
            helper(idx+1,lCount,rCount,s,sb,res);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) {
        String s = ")(";
        RemoveInvalidParenthese inst = new RemoveInvalidParenthese();
        List<String> res = inst.removeInvalidParentheses(s);
        for(String str : res){
            System.out.println(str);
        }
    }
}
