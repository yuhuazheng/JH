package Algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuhua on 10/7/15.
 */
public class FactorCombinations {

    public static void main(String[] args){
        FactorCombinations inst = new FactorCombinations();
        List<List<Integer>> res = inst.getFactors(32);
        for(List<Integer> cur : res){
            System.out.println(cur.toString());
        }

    }

    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(n<2) return res;

        helper(n,2,new ArrayList<Integer>(),res);
        return res;
    }

    private void helper(int n, int start, ArrayList<Integer> cur, List<List<Integer>> res){
        if(n==1){
            if(cur.size()>1) //to rule out the original number itself
                res.add(new ArrayList<Integer>(cur));
        }

        for(int i=start;i<=n;i++){
            if(n%i!=0){
                continue;
            }
            else{
                cur.add(i);
                helper(n/i,i,cur,res);
                cur.remove(cur.size()-1);
            }
        }
    }
}
