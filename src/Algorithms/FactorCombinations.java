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

        List<Integer> item = new ArrayList<Integer>();
        helper(n, item, res);
        return res;
    }

    private void helper(int n, List<Integer> item, List<List<Integer>> res){
        if(n==1){
            return;
        }

        int divider=item.size()==0?2:item.get(item.size()-1); //keep increase order of factors, ensure no dup
        int remainer=n;
        while(divider<=n/2){
            if(n%divider!=0){
                divider++;
                continue;
            }
            remainer = n/divider;
            if(divider>remainer){
                break;
            }
            //add current combine into res
            item.add(divider);
            item.add(remainer);
            res.add(new ArrayList<Integer>(item));

            //backtracking remainer and break down the remainer
            item.remove(item.size()-1);
            helper(remainer, item, res);

            //backtracking divider
            item.remove(item.size()-1);
            divider++;
        }
    }
}
