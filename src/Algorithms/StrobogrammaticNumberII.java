package Algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuhuazh on 10/12/2015.
 */
public class StrobogrammaticNumberII {

    public static void main(String[] args){
        StrobogrammaticNumberII inst = new StrobogrammaticNumberII();
        List<String> res = inst.findStrobogrammatic(3);
        System.out.println(res);
    }

    public List<String> findStrobogrammatic(int n) {
        List<String> res = new ArrayList<>();
        if(n<=0) return res;

        if(n%2==0) helper(n, new StringBuilder(), res);
        else{
            helper(n, new StringBuilder("0"), res);
            helper(n,new StringBuilder("1"),res);
            helper(n,new StringBuilder("8"),res);
        }
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
}
