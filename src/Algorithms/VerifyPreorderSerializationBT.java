package Algorithms;

import java.util.Stack;

/**
 * Created by yuhuazh on 3/13/2016.
 */
public class VerifyPreorderSerializationBT {
    public boolean isValidSerialization(String preorder) {
        if(preorder==null||preorder.length()==0) return true;
        if(preorder.length()==1 && preorder.charAt(0)=='#') return true;

        String[] tokens = preorder.split(",");
        Stack<String> stk = new Stack<>();
        stk.push(tokens[0]);
        for(int i=1;i<tokens.length;i++) {
            String cur = tokens[i];
            if(!cur.equals("#")){
                stk.push(cur);
            }
            else{//c=='#'
                while(!stk.isEmpty()&&stk.peek().equals("#")){
                    //two consecutive # means a leaf
                    stk.pop();
                    if(stk.isEmpty()) return false;
                    stk.pop();
                }
                if(!stk.isEmpty()) {
                    stk.push("#");
                }
                else{
                    return i==tokens.length-1;
                }
            }
        }
        return stk.isEmpty();
    }

    public static void main(String[] args) {
        VerifyPreorderSerializationBT inst = new VerifyPreorderSerializationBT();
        String preorder = "9,#,92,#,#";
        System.out.println(inst.isValidSerialization(preorder));
    }
}
