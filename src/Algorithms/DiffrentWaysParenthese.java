package Algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuhua on 10/12/15.
 */
public class DiffrentWaysParenthese {

    public static void main(String[] args){
        String input = "10+5";
        DiffrentWaysParenthese inst = new DiffrentWaysParenthese();
        List<Integer> res = inst.diffWaysToCompute(input);
        System.out.println(res);
    }

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        if(input==null||input.length()==0) return res;

        res=helper(input,0,input.length()-1);
        return res;
    }

    private List<Integer> helper(String input, int start, int end){
        List<Integer> res = new ArrayList<>();
        if(input==null||input.length()==0 || start>end || start<0 || end>=input.length()) return res;

        //whole substring is a number
        String sub = input.substring(start,end+1);
        if(sub.indexOf('+')<0 && sub.indexOf('-')<0 && sub.indexOf('*')<0){
            res.add(Integer.parseInt(sub));
            return res;
        }

        //divide and conquer
        for(int i=start;i<=end;i++){
            char op = input.charAt(i);
            if(op=='+'||op=='-'||op=='*'){
                List<Integer> left = helper(input,start,i-1);
                List<Integer> right = helper(input,i+1,end);
                for(Integer l : left){
                    for(Integer r: right){
                        if(op=='+') res.add(l+r);
                        else if(op=='-') res.add(l-r);
                        else res.add(l*r);
                    }
                }
            }
        }
        return res;
    }
}
