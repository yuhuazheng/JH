package Algorithms;

import java.util.Stack;

class MinStack {
    Stack<Integer> mainStack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();
	
	public void push(int x) {
        mainStack.push(x);
        if(minStack.isEmpty()){
        	minStack.push(x);
        }
        else if(minStack.peek()>=x){
        	minStack.push(x);
        }
    }

    public void pop() {
        int temp = mainStack.pop();
        if(temp==minStack.peek()) minStack.pop();
    }

    public int top() {
        return mainStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
