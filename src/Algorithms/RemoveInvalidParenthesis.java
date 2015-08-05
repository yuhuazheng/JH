package Algorithms;

import java.util.Stack;

/**
 * Created by yuhuazh on 7/31/2015.
 */
public class RemoveInvalidParenthesis {

    public static void main(String[] args){
        String str = ")1ab(akjv))((fjkdfjdl)";
        Stack<Integer> stk = new Stack<Integer>();
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            if(c=='(') stk.push(i);
            if(c==')'){
                if(!stk.isEmpty()&& str.charAt(stk.peek())=='(')
                    stk.pop();
                else
                    stk.push(i);
            }
        }
        StringBuilder res = new StringBuilder(str);
        while(!stk.isEmpty()){
            res.deleteCharAt(stk.pop());
        }
        System.out.println(res.toString());
    }
}
