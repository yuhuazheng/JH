package myPractice;

import java.util.ArrayList;
import java.util.List;

public class MinStack {
	List<Integer> elements = new ArrayList<Integer>();
	List<Integer> mins = new ArrayList<Integer>();
	
	public void push(int x) {
        elements.add(x);
        if(mins.isEmpty() || x< mins.get(mins.size()-1)){
        	mins.add(x);
        }
    }

    public void pop() {
        if(elements.isEmpty()){
        	return;
        }
    	int value = elements.remove(elements.size()-1);
    	if(!mins.isEmpty()&& mins.get(mins.size()-1)==value){
    		mins.remove(mins.size()-1);
    	}
    }

    public int top() {
        if(elements.isEmpty()){
        	return Integer.MAX_VALUE;
        }
    	return elements.get(elements.size()-1);
    }

    public int getMin() {
    	if(mins.isEmpty()){
        	return Integer.MAX_VALUE;
        }
    	return mins.get(mins.size()-1);
    }
    
    
    public static void main(String[] args){
    	MinStack stacker = new MinStack();
    	stacker.push(2147483646);
    	stacker.push(2147483646);
    	stacker.push(2147483647);
    	stacker.top();
    	stacker.pop();
    	stacker.getMin();
    	stacker.pop();
    	stacker.getMin();
    	stacker.pop();
    	stacker.push(2147483647);
    	stacker.top();
    	stacker.getMin();
    	stacker.push(-2147483648);
    	stacker.top();
    	stacker.getMin();
    	stacker.pop();
    	stacker.getMin();
    }
}
