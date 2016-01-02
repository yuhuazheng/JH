package Algorithms;

import java.util.Stack;

public class ValidParentheses {

	public static void main(String[] args){
		ValidParentheses helper = new ValidParentheses();
		System.out.println(helper.isValid("()[]{}"));
	}
	
	public boolean isValid(String s) {
		if(s.length()==0 || s=="") return true;
		if(s.length()%2!=0) return false;
		Stack<Character> stk = new Stack<Character>();
		for(int i=0;i<s.length();i++){
			char c = s.charAt(i);
			if(c=='('||c=='['||c=='{') stk.push(c);
			if(c==')'||c==']'||c=='{'){
				if(stk.isEmpty()) return false;
				char c2 = stk.pop();
				if( (c==')'&&c2!='(') || (c==']'&&c2!='[') || (c=='}'&&c2!='{')) return false;
			}
		}
		return stk.isEmpty();
	}
}
