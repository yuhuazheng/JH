package Algorithms;

import java.util.Stack;

public class LongestValidParenthese {

	public static void main(String[] args){
		String s ="((()))(()))))())()";
		LongestValidParenthese inst = new LongestValidParenthese();
		System.out.println(inst.longestValidParentheses(s));
	}
	
	public int longestValidParentheses(String s) {
		if(s==null || s.length()<=1)	return 0;
		if(s.indexOf(')')<0) return 0;
		int maxlen=0;
		int start =0;
		Stack<Integer> stk = new Stack<Integer>();
		
		for(int i=0; i<s.length();i++){
			char c = s.charAt(i);
			if(c=='('){
				stk.push(i);
			}
			else{
				if(stk.isEmpty()){
					start=i+1;
				}
				else{
					stk.pop();
					if(stk.isEmpty()){
						maxlen=Math.max(maxlen, i-start+1);
					}
					else{
						maxlen=Math.max(maxlen, i-stk.peek());
					}
				}
			}
		}
		return maxlen;
	}
}
