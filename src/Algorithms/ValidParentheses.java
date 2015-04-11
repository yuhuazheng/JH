package Algorithms;

import java.util.Stack;

public class ValidParentheses {

	public static void main(String[] args){
		ValidParentheses helper = new ValidParentheses();
		helper.isValid("()[]{}");
	}
	
	public boolean isValid(String s) {
		if(s==null || s.length()<1){
			return true;
		}
		Stack<Character> buf = new Stack<Character>();
		for(int i=0;i<s.length();i++){
			Character c = s.charAt(i);
			if(c=='(' || c=='{' || c=='['){
				buf.push(c);
			}
			else if(c==')'){
				if(buf.isEmpty()){
					return false;
				}
				Character l = buf.peek();
				if(l=='('){
					buf.pop();
				}
				else{
					return false;
				}
			}
			else if(c=='}'){
				if(buf.isEmpty()){
					return false;
				}
				Character l = buf.peek();
				if(l=='{'){
					buf.pop();
				}
				else{
					return false;
				}
			}
			else if(c==']'){
				if(buf.isEmpty()){
					return false;
				}
				Character l = buf.peek();
				if(l=='['){
					buf.pop();
				}
				else{
					return false;
				}
			}
			//omit all other char
		}
		if(buf.isEmpty()){
			return true;
		}
		else{
			return false;
		}
	}
}
