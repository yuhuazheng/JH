package Algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuhua on 10/12/15.
 */
public class DiffrentWaysParenthese {

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        if(input==null||input.length()==0) return res;

        for(int i=0;i<input.length();i++){
            char op = input.charAt(i);
            if(op=='+'||op=='-'||op=='*'){
                List<Integer> left = (input,0,i-1);
                List<Integer> right = (input,i+1,input.length()-1);
                for(Integer l : left){
                    for(Integer r: right){
                        int cur=0;
                        if(op=='+') res.add(l+r);
                        if(op=='-') res.add(l-r);
                        if(op=='*') res.add(l*r);
                    }
                }
            }
        }
        return res;
    }

    private List<Integer> helper(String input, int start, int end){

    }
}
